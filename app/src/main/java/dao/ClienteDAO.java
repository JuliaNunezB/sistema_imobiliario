package dao;

import model.Cliente;
import model.Imovel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ClienteDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ClienteDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long inserirCliente(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLUMN_CLIENTE_ID, cliente.getId());
        values.put(dbHelper.COLUMN_CLIENTE_NOME, cliente.getNome());
        values.put(dbHelper.COLUMN_CLIENTE_TELEFONE, cliente.getTelefone());
        values.put(dbHelper.COLUMN_CLIENTE_EMAIL, cliente.getEmail());

        return db.insert(dbHelper.TABLE_CLIENTES, null, values);
    }

    public Cliente buscarClientePorId(String id) {
        Cursor cursor = db.query(DBHelper.TABLE_IMOVEIS,
                null,
                DBHelper.COLUMN_CLIENTE_ID + "=?",
                new String[]{id},
                null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            Cliente cliente = new Cliente(



                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_CLIENTE_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_CLIENTE_NOME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_CLIENTE_TELEFONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_CLIENTE_ID))
            );
            cursor.close();
            return cliente;
        } else {
            return null;
        }
    }

    public int atualizarCliente(Cliente cliente) {
        ContentValues values = new ContentValues();

        values.put(dbHelper.COLUMN_CLIENTE_ID, cliente.getId());
        values.put(dbHelper.COLUMN_CLIENTE_NOME, cliente.getNome());
        values.put(dbHelper.COLUMN_CLIENTE_TELEFONE, cliente.getTelefone());
        values.put(dbHelper.COLUMN_CLIENTE_EMAIL, cliente.getEmail());


        return db.update(dbHelper.TABLE_IMOVEIS, values, dbHelper.COLUMN_CLIENTE_ID + " = ?", new String[]{cliente.getId()});
    }

    public void deletarCliente(String id) {
        db.delete(DBHelper.TABLE_IMOVEIS, DBHelper.COLUMN_CLIENTE_ID + " = ?", new String[]{id});
    }


}

