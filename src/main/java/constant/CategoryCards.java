package constant;

/**
 * Перечисление CategoryCards представляет категории карточек на главной странице приложения.
 */
public enum CategoryCards {
    // Определение категорий карточек с их названиями
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS_FRAME_AND_WINDOWS("Alerts, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APPLICATION("Book Store Application");

    // Переменная для хранения имени категории
    private String name;

    /**
     * Конструктор для инициализации имени категории.
     *
     * @param name Название категории.
     */
    private CategoryCards(String name) {
        this.name = name;
    }

    /**
     * Метод для получения имени категории.
     *
     * @return Возвращает название категории.
     */
    public String getName() {
        return name;
    }
}
