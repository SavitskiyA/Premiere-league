package elementrdtesttask.com.elementrdtesttask;

/**
 * Created by Andrey on 19.04.2017.
 */

public class RowModel {
    private String name;
    private String position;
    private String number;
    private int photo;

    public RowModel(String name, String position, String number, int photo) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.photo = photo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
