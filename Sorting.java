import java.util.Collections;
import java.util.List;

class Sorting {
    // Quick sort for books based on title
    public static void quickSort(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, int low, int high) {
        Book pivot = books.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (books.get(j).getTitle().compareTo(pivot.getTitle()) < 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
