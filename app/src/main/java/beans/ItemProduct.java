package beans;

public class ItemProduct {
    private int image;
    private String title;
    private String store;
    private String localization;
    private String phone;
    private String description;

    public ItemProduct(int image, String title, String store, String localization, String phone, String description) {
        this.image = image;
        this.title = title;
        this.store = store;
        this.localization = localization;
        this.phone = phone;
        this.description = description;
    }

    public ItemProduct() {
        setImage(0);
        setDescription("");
        setLocalization("");
        setPhone("");
        setStore("");
        setTitle("");
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", localization='" + localization + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localitation) {
        this.localization = localitation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
