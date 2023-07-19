import java.util.*;

public class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String operatingSystem;
    private String color;

    public Notebook(String model, int ram, int storage, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }




    protected static Map<String, Object> getFilterCriteriaFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion;
        do {
            criterion = scanner.nextInt();
        } while (criterion < 1 || criterion > 4);

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                int minRAM = scanner.nextInt();
                filterCriteria.put("RAM", minRAM);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filterCriteria.put("storage", minStorage);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filterCriteria.put("operatingSystem", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filterCriteria.put("color", color);
                break;
        }

        return filterCriteria;
    }

    protected static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            if (notebook.meetsCriteria(filterCriteria)) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    private boolean meetsCriteria(Map<String, Object> filterCriteria) {
        for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "RAM":
                    if (ram < (int) value) return false;
                    break;
                case "storage":
                    if (storage < (int) value) return false;
                    break;
                case "operatingSystem":
                    if (!operatingSystem.equalsIgnoreCase((String) value)) return false;
                    break;
                case "color":
                    if (!color.equalsIgnoreCase((String) value)) return false;
                    break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}