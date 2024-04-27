import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";

    // SQL query to create the users table
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FIRST_NAME + " TEXT,"
                    + COLUMN_LAST_NAME + " TEXT,"
                    + COLUMN_EMAIL + " TEXT UNIQUE,"
                    + COLUMN_PASSWORD + " TEXT,"
                    + COLUMN_PHONE_NUMBER + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Method to add a new user to the database
    public long addUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstName);
        values.put(COLUMN_LAST_NAME, lastName);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_PHONE_NUMBER, phoneNumber);

        long result = db.insert(TABLE_USERS, null, values);
        db.close();

        return result;
    }

    // Method to check if a user with the given email exists in the database
    public boolean checkUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID},
                COLUMN_EMAIL + "=?", new String[]{email},
                null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    // Method to verify the login credentials of a user
    public boolean verifyLogin(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID},
                COLUMN_EMAIL + "=? AND " + COLUMN_PASSWORD + "=?",
                new String[]{email, password}, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
}
