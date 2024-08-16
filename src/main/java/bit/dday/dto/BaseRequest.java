package bit.dday.dto;

public interface BaseRequest<T> {
    public T toEntity();
}
