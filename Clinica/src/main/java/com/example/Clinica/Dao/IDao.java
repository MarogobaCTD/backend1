package com.example.Clinica.Dao;

import java.sql.SQLException;

public interface IDao<T> {

    public T cadastrar (T t);
    public T buscar (Integer id);
    public void deletar (Integer id);
    public T salvar (T t);
    public T atualizar(T t) throws SQLException;

}
