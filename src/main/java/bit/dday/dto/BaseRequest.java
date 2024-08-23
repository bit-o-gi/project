package bit.dday.dto;

public interface BaseRequest<T> {
    BaseCommand<T> toCommand();
}
