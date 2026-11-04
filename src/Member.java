public record Member(String name, int memberNumber) implements Comparable <Member> {
    @Override
    public int compareTo(Member other) {
        return Integer.compare(this.memberNumber(), other.memberNumber());
    }
}