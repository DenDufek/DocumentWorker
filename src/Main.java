import java.util.Scanner;

class DocumentWorker {
    public void openDocument() {
        System.out.println("Документ відкритий");
    }

    public void editDocument() {
        System.out.println("Правка документа доступна у версії Про");
    }

    public void saveDocument() {
        System.out.println("Збереження документа доступне у версії Про");
    }
}

class ProDocumentWorker extends DocumentWorker {
    @Override
    public void editDocument() {
        System.out.println("Документ відредаговано");
    }

    @Override
    public void saveDocument() {
        System.out.println("Документ збережено у старому форматі, збереження в інших форматах доступне у версії Експерт");
    }
}

class ExpertDocumentWorker extends ProDocumentWorker {
    @Override
    public void saveDocument() {
        System.out.println("Документ збережено в новому форматі");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер ключа доступу (pro або exp):");
        String key = scanner.next();
        scanner.close();

        DocumentWorker document;

        if (key.equals("pro")) {
            document = new ProDocumentWorker();
        } else if (key.equals("exp")) {
            document = new ExpertDocumentWorker();
        } else {
            document = new DocumentWorker();
        }

        document.openDocument();
        document.editDocument();
        document.saveDocument();
    }
}
