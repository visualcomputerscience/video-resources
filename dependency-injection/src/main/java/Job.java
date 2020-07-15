public class Job implements Comparable {
    private Integer id;

    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        return id.compareTo(((Job) o).id);
    }
}
