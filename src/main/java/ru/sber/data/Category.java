package ru.sber.data;

/**
 * Категории товаров
 * @author Alexey Dybov
 * @created 18.11.16
 */
public enum Category {

    Computers("54425", "Компьютеры"),
    Notebooks("91013", "Ноутбуки"),
    Tablet("6427100", "Планшеты");

    private String id;
    private String description;

    Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
