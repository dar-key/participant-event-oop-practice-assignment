public void sortEventsByTime() {
        Collections.sort(events);
        System.out.println("\nEvents Sorted by Time!");
    }

    public void sortEventsByTitle() {
        events.sort(Comparator.comparing(Event::getTitle));
        System.out.println("\nEvents Sorted by Title!");
    }