package constant;

/**
 * Перечисление Item представляет различные элементы интерфейса, доступные в приложении.
 */
public enum Item {
    // Определение элементов с их названиями
    TEXT_BOX("Text Box"),
    CHECK_BOX("Check Box"),
    RADIO_BUTTON("Radio Button"),
    WEB_TABLES("Web Tables"),
    BUTTONS("buttonTests"),
    LINKS("Links"),
    BROKEN_LINKS_IMAGES("Broken Links - Images"),
    UPLOAD_AND_DOWNLOAD("Upload and Download"),
    DYNAMIC_PROPERTIES("Dynamic Properties"),
    PRACTICE_FORM("Practice Form"),
    BROWSER_WINDOWS("Browser Windows"),
    ALERTS("Alerts"),
    FRAMES("Frames"),
    NESTED_FRAMES("Nested Frames"),
    MODAL_DIALOGS("Modal Dialogs"),
    ACCORDIAN("Accordian"),
    AUTO_COMPLETE("Auto Complete"),
    DATE_PICKER("Date Picker"),
    SLIDER("Slider"),
    PROGRESS_BAR("Progress Bar"),
    TABS("Tabs"),
    TOOL_TIPS("Tool Tips"),
    MENU("Menu"),
    SELECT_MENU("Select Menu"),
    SORTABLE("Sortable"),
    SELECTABLE("Selectable"),
    RESIZABLE("Resizable"),
    DROPPABLE("Droppable"),
    DRAGABBLE("Dragabble"),
    LOGIN("Login"),
    BOOK_STORE("Book Store"),
    PROFILE("Profile"),
    BOOK_STORE_API("Book Store API");

    // Переменная для хранения названия элемента
    private String itemName;

    /**
     * Конструктор для инициализации названия элемента.
     *
     * @param itemName Название элемента.
     */
    private Item(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Метод для получения названия элемента.
     *
     * @return Возвращает название элемента.
     */
    public String getName() {
        return itemName;
    }
}
