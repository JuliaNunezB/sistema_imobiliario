package dao;

import model.Imovel;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.util.Log;

public class ImovelDAO {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ImovelDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long inserirImovel(Imovel imovel) {
        ContentValues values = new ContentValues();
        values.put(dbHelper .COLUMN_IMOVEL_ID, imovel.getId());
        values.put(dbHelper.COLUMN_IMOVEL_ENDERECO, imovel.getEndereco());
        values.put(dbHelper.COLUMN_IMOVEL_PRECO, imovel.getPreco());
        values.put(dbHelper.COLUMN_IMOVEL_TIPO, imovel.getTipo());
        values.put(dbHelper.COLUMN_IMOVEL_DESCRICAO, imovel.getDescricao());
        values.put(dbHelper.COLUMN_IMOVEL_DISPONIVEL, imovel.isDisponivel() ? 1 : 0);


        //db.close(); // confirmar o momento adequado para fechar

        return db.insert(dbHelper.TABLE_IMOVEIS, null, values);
    }



    public Imovel buscarImovelPorId(String id) {
        Cursor cursor = db.query(DBHelper.TABLE_IMOVEIS,
                null,
                DBHelper.COLUMN_IMOVEL_ID + "=?",
                new String[]{id},
                null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            Imovel imovel = new Imovel(
                    cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_ENDERECO)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_PRECO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_TIPO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_DESCRICAO)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_IMOVEL_DISPONIVEL)) == 1
            );
            cursor.close();
            return imovel;
        } else {
            return null;
        }
    }

    public int atualizarImovel(Imovel imovel) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLUMN_IMOVEL_ENDERECO, imovel.getEndereco());
        values.put(dbHelper.COLUMN_IMOVEL_PRECO, imovel.getPreco());
        values.put(dbHelper.COLUMN_IMOVEL_TIPO, imovel.getTipo());
        values.put(dbHelper.COLUMN_IMOVEL_DESCRICAO, imovel.getDescricao());
        values.put(dbHelper.COLUMN_IMOVEL_DISPONIVEL, imovel.isDisponivel() ? 1 : 0);

        return db.update(dbHelper.TABLE_IMOVEIS, values, dbHelper.COLUMN_IMOVEL_ID + " = ?", new String[]{String.valueOf(imovel.getId())});
    }

    public void deletarImovel(String id) {
        db.delete(DBHelper.TABLE_IMOVEIS, DBHelper.COLUMN_IMOVEL_ID + " = ?", new String[]{id});
    }


}
