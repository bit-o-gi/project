package bit.dday.dto;

public interface BaseRequest<T> {
    T toEntity();
}
