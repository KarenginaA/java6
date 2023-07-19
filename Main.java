import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook("Model1", 8, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Model2", 16, 1024, "macOS", "Silver"));
        notebooks.add(new Notebook("Model3", 4, 256, "Linux", "Red"));


        Map<String, Object> filterCriteria = Notebook.getFilterCriteriaFromUser();
        Set<Notebook> filteredNotebooks = Notebook.filterNotebooks(notebooks, filterCriteria);

        System.out.println("Результаты фильтрации:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }

    }

}