import os
from os.path import join
from flask import Flask, request, jsonify, abort
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow
from marshmallow import fields, validate, post_load, ValidationError
from marshmallow_enum import EnumField
from enum import Enum

app = Flask(__name__)

db = SQLAlchemy(app)
ma = Marshmallow(app)


class Acids(Enum):
    H2SO4 = 0
    C2H5OH = 1
    HNO3HCL = 2


class TypeOfMaterial(Enum):
    Glass = 0
    Plastic = 1
    Metal = 2
    Carbon = 3


class ChemicalEquipment(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(32), nullable=False)
    price = db.Column(db.Float, nullable=False)
    weight_in_grams = db.Column(db.Integer, nullable=False)
    year = db.Column(db.Integer, nullable=False)
    brand = db.Column(db.String(32), nullable=False)
    acid = db.Column(db.Enum(Acids))
    type_of_material = db.Column(db.Enum(TypeOfMaterial))

    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", acid: Acids = None, type_of_material: TypeOfMaterial = None):
        self.name = name
        self.price = price
        self.weight_in_grams = weight_in_grams
        self.year = year
        self.brand = brand
        self.acid = acid
        self.type_of_material = type_of_material

    def __str__(self):
        return f"Name: {self.name}\n" \
               f"Price: {self.price}\n" \
               f"Weight in grams: {self.weight_in_grams}\n" \
               f"Year: {self.year}\n" \
               f"Brand: {self.brand}\n" \
               f"Acid: {self.acid}\n" \
               f"TypeOfMaterial: {self.type_of_material}\n"


class ChemicalEquipmentSchema(ma.Schema):

    name = fields.Str(validate=validate.Length(min=1, max=32))
    price = fields.Float(validate=validate.Range(min=0.0, max=9999.0))
    weight_in_grams = fields.Int(validate=validate.Range(min=0, max=9999))
    year = fields.Int(validate=validate.Range(min=1900, max=9999))
    brand = fields.Str(validate=validate.Length(min=1, max=32))
    acid = EnumField(Acids)
    type_of_material = EnumField(TypeOfMaterial)

    @post_load
    def make_chemical_equipment(self, data, **kwargs):
        return ChemicalEquipment(**data)


chemicalEquipment_schema = ChemicalEquipmentSchema()
chemicalEquipments_schema = ChemicalEquipmentSchema(many=True)


# endpoint to create new chemical_equipment
@app.route("/ChemicalEquipment", methods=["POST"])
def add_chemical_equipment():
    try:
        chemical_equipment = chemicalEquipment_schema.load(request.json)
        db.session.add(chemical_equipment)
    except ValidationError as err:
        abort(400, err)
    db.session.commit()
    return chemicalEquipment_schema.jsonify(chemical_equipment)


# endpoint to show all chemical_equipment
@app.route("/ChemicalEquipment", methods=["GET"])
def get_chemical_equipment():
    all_chemical_equipment = ChemicalEquipment.query.all()
    return chemicalEquipments_schema.jsonify(all_chemical_equipment)


# endpoint to get chemical_equipment detail by id
@app.route("/ChemicalEquipment/<id>", methods=["GET"])
def chemical_equipment_detail(id):
    chemical_equipment = ChemicalEquipment.query.get(id)
    if not chemical_equipment:
        response = jsonify({
            'status': 404,
            'description': "id not found"
        })
        abort(404, response)
    return chemicalEquipment_schema.jsonify(chemical_equipment)


# endpoint to update chemical_equipment
@app.route("/ChemicalEquipment/<id>", methods=["PUT"])
def chemical_equipment_update(id):
    chemical_equipment = ChemicalEquipment.query.get(id)
    if not chemical_equipment:
        response = jsonify({
            'status': 404,
            'description': "id not found"
        })
        abort(404, response)
    try:
        chemical_equipment_req = chemicalEquipment_schema.load(request.json)
        chemical_equipment.name = chemical_equipment_req.name
        chemical_equipment.price = chemical_equipment_req.price
        chemical_equipment.weight_in_grams = chemical_equipment_req.weight_in_grams
        chemical_equipment.year = chemical_equipment_req.year
        chemical_equipment.brand = chemical_equipment_req.brand
        chemical_equipment.acid = chemical_equipment_req.acid
        chemical_equipment.type_of_material = chemical_equipment_req.type_of_material
    except ValidationError as err:
        abort(400, err)
    db.session.commit()
    return chemicalEquipment_schema.jsonify(chemical_equipment)


# endpoint to delete chemical_equipment
@app.route("/ChemicalEquipment/<id>", methods=["DELETE"])
def chemical_equipment_delete(id):
    chemical_equipment = ChemicalEquipment.query.get(id)
    if not chemical_equipment:
        response = jsonify({
            'status': 404,
            'description': "id not found"
        })
        abort(404, response)
    db.session.delete(chemical_equipment)
    db.session.commit()

    return chemicalEquipment_schema.jsonify(chemical_equipment)


if __name__ == '__main__':
    try:
        app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
        app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+mysqlconnector://root:111@localhost:3306/chemical_equipment'
        db.create_all(app=app)
    except Exception as e:
        print(e)
        print("CANNOT CONNECT TO DB(CHECK SQLALCHEMY_DATABASE_URI IF THIS FIELD IS OK) CREATING SQLITE DB")
        dbdir = os.path.abspath(os.path.dirname(__file__))
        app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
        app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + join(dbdir, 'db.sqlite')
        db.create_all(app=app)
    app.run()
