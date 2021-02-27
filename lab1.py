class Notebook:
    notebook_count: int = 0

    def __init__(self, color : str = "", pages : int = 0 , price : int = 0, size : str = "", format_rozmitky : str = "", weight : int = 0) -> None :
        self.color = color 
        self.pages = pages
        self.price = price
        self.size = size
        self.format_rozmitky = format_rozmitky
        self.weight = weight
        Notebook.notebook_count += 1
    
    def __str__(self) -> str:
        return f"Notebook:\n color: {self.color}\n pages : {self.pages}\n price : {self.price}\n size : {self.size}\n format_rozmitky : {self.format_rozmitky}\n weight : {self.weight}\n" 

    @staticmethod
    def get_count(cls) -> int:
        return cls.notebook_count

    def __del__(self):
        Notebook.notebook_count -= 1

def main() -> None:
    notebooks: list[Notebook] = [
        Notebook("blue", 96, 50, "20x15 см", "klitynka", 50),
        Notebook("green", 64, 39, "10x30 см", "liniyka", 40),
        Notebook("yellow", 36, 15, "10x15 cм", "kosa liniyka", 25)
    ]
    for notebook in notebooks:
        print(notebook)

if __name__ == "__main__":
      main()
