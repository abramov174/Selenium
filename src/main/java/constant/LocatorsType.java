package constant;

/**
 * Перечисление LocatorsType определяет доступные типы локаторов для поиска элементов на веб-странице.
 */
public enum LocatorsType {
    ID,           // Локатор по ID элемента
    NAME,         // Локатор по имени элемента
    XPATH,        // Локатор по XPath выражению
    CSS,          // Локатор по CSS селектору
    CLASS_NAME,   // Локатор по имени класса
    TAG_NAME      // Локатор по имени тега
}
