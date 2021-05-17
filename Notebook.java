public class Notebook {
    private String color;
    private int amountOfPages;
    private int price;
    private String size;
    private String formatRozmitky;
    private int weight;
    private String type;
    private String type2;
    private static int count;
    protected boolean isOpened;
    protected boolean isEmpty;

    public Notebook(){
        Notebook.count++;
    }

    public Notebook(String newSize, String newFormatRozmitky, int newWeight, String newType){
        this("", 0, 0, newSize, newFormatRozmitky, newWeight, newType, "", false, true);
    }

    public Notebook(String newColor, int newAmountOfPages, int newPrice, String newSize, String newFormatRozmitky, 
                    int newWeight, String newType, String newType2, boolean newIsOpened, boolean newIsEmpty){
        Notebook.count++;
        resetValues(newColor, newAmountOfPages, newPrice, newSize, newFormatRozmitky, newWeight, 
                    newType,  newType2, newIsOpened, newIsEmpty);
    }

    public void resetValues(String newColor, int newAmountOfPages, int newPrice, String newSize, String newFormatRozmitky, 
                            int newWeight, String newType, String newType2, boolean newIsOpened, boolean newIsEmpty){
        color = newColor;
        amountOfPages = newAmountOfPages;
        price = newPrice;
        size = newSize; 
        formatRozmitky = newFormatRozmitky;
        weight = newWeight; 
        type = newType;
        type2 = newType2;
        isOpened = newIsOpened;
        isEmpty = newIsEmpty; 
    }

    public String getColor(){
        return color;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public int getAmountOfPages(){
        return amountOfPages;
    }

    public void setAmountOfPages(int newAmountOfPages){
        amountOfPages = newAmountOfPages;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String newSize){
        size = newSize;
    }

    public String getFormatRozmitky(){
        return formatRozmitky;
    }

    public void setFormatRozmitky(String newFormatRozmitky){
        formatRozmitky = newFormatRozmitky;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int newWeight){
        weight = newWeight;
    }

    public String getType(){
        return type;
    }

    public void setType(String newType){
        type = newType;
    }

    public String getTyp2(){
        return type2;
    }

    public void setType2(String newType2){
        type2 = newType2;
    }

    public boolean getIsOpened(){
        return isOpened;
    }

    public void setIsOpened(boolean newIsOpened){
        isOpened = newIsOpened;
    }

    public boolean getIsEmpty(){
        return isEmpty;
    }

    public void setIsEmpty(boolean newIsEmpty){
        isEmpty = newIsEmpty;
    }

    public String toString(){
        return "Notebook[" + color + ", " + amountOfPages + ", " + price + ", " + size + ", " + formatRozmitky + ", " +
                        + weight + ", " + type + ", " + type2 + ", " + isOpened + ", " + isEmpty + "]"; 
    }

    public int getCount(){
        return count;
    }

    public static int getStaticCount(){
        return count;
    }
    public static void main(String[] args){
        Notebook helloKitty = new Notebook();
        Notebook forsazh = new Notebook("10x15", "klitynka", 10, "planner");
        Notebook musya = new Notebook("green", 64, 40, "19x25", "liniyka", 30, "for notes", "boys", true, false);

        System.out.println(helloKitty);
        System.out.println(forsazh);
        System.out.println(musya);
        System.out.println(musya.getCount());
        System.out.println(Notebook.getStaticCount());
    }
}
