import java.util.List;

class Searching {
    // Binary search for a book by title in a sorted list
    public static Book binarySearch(List<Book> sortedBooks, String title) {
        int left = 0, right = sortedBooks.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks.get(mid).getTitle().compareTo(title);

            if (comparison == 0)
                return sortedBooks.get(mid);
            if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null; // Book not found
    }
}
