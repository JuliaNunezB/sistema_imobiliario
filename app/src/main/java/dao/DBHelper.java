package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sistema_imobiliario.db";
    private static final int DATABASE_VERSION = 1;

    // Tabelas e colunas
    public static final String TABLE_IMOVEIS = "imoveis";
    public static final String COLUMN_IMOVEL_ID = "id";
    public static final String COLUMN_IMOVEL_ENDERECO = "endereco";
    public static final String COLUMN_IMOVEL_PRECO = "preco";
    public static final String COLUMN_IMOVEL_TIPO = "tipo";
    public static final String COLUMN_IMOVEL_DESCRICAO = "descricao";
    public static final String COLUMN_IMOVEL_DISPONIVEL = "disponivel";

    public static final String TABLE_CLIENTES = "clientes";
    public static final String COLUMN_CLIENTE_ID = "id";
    public static final String COLUMN_CLIENTE_NOME = "nome";
    public static final String COLUMN_CLIENTE_TELEFONE = "telefone";
    public static final String COLUMN_CLIENTE_EMAIL = "email";

    public static final String TABLE_TRANSACOES = "transacoes";
    public static final String COLUMN_TRANSACAO_ID = "id";
    public static final String COLUMN_TRANSACAO_IMOVEL_ID = "imovel_id";
    public static final String COLUMN_TRANSACAO_CLIENTE_ID = "cliente_id";
    public static final String COLUMN_TRANSACAO_DATA = "data";
    public static final String COLUMN_TRANSACAO_VALOR = "valor";
    public static final String COLUMN_TRANSACAO_TIPO = "tipo";

    // SQL para criar as tabelas
    private static final String CREATE_TABLE_IMOVEIS = "CREATE TABLE " + TABLE_IMOVEIS + " (" +
            COLUMN_IMOVEL_ID + " TEXT PRIMARY KEY, " +
            COLUMN_IMOVEL_ENDERECO + " TEXT, " +
            COLUMN_IMOVEL_PRECO + " REAL, " +
            COLUMN_IMOVEL_TIPO + " TEXT, " +
            COLUMN_IMOVEL_DESCRICAO + " TEXT, " +
            COLUMN_IMOVEL_DISPONIVEL + " INTEGER)";

    private static final String CREATE_TABLE_CLIENTES = "CREATE TABLE " + TABLE_CLIENTES + " (" +
            COLUMN_CLIENTE_ID + " TEXT PRIMARY KEY, " +
            COLUMN_CLIENTE_NOME + " TEXT, " +
            COLUMN_CLIENTE_TELEFONE + " TEXT, " +
            COLUMN_CLIENTE_EMAIL + " TEXT)";

    private static final String CREATE_TABLE_TRANSACOES = "CREATE TABLE " + TABLE_TRANSACOES + " (" +
            COLUMN_TRANSACAO_ID + " TEXT PRIMARY KEY, " +
            COLUMN_TRANSACAO_IMOVEL_ID + " TEXT, " +
            COLUMN_TRANSACAO_CLIENTE_ID + " TEXT, " +
            COLUMN_TRANSACAO_DATA + " TEXT, " +
            COLUMN_TRANSACAO_VALOR + " REAL, " +
            COLUMN_TRANSACAO_TIPO + " TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação das tabelas
        db.execSQL(CREATE_TABLE_IMOVEIS);
        db.execSQL(CREATE_TABLE_CLIENTES);
        db.execSQL(CREATE_TABLE_TRANSACOES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se o banco de dados for atualizado, as tabelas existentes serão removidas e recriadas
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMOVEIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACOES);
        onCreate(db);
    }
}

