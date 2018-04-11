package calculation;

public class Result {

    private final double result;

    public Result(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result1 = (Result) o;

        return result == result1.result;
    }

    public double getResult() {
        return result;
    }
}
