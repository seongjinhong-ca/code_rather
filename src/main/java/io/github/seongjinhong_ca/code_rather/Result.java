package io.github.seongjinhong_ca.code_rather;

import org.springframework.jdbc.core.DataClassRowMapper;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

final class Result {
    private final UUID id;
    private final String code;

    Result(UUID id, String code) {
        this.id = id;
        this.code = code;
    }

    public UUID id() {
        return id;
    }

    public String code() {
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Result) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "Result[" +
                "id=" + id + ", " +
                "code=" + code + ']';
    }
}
