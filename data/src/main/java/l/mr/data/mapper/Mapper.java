package l.mr.data.mapper;

public interface Mapper<From, To> {
    To map(From from);
}
