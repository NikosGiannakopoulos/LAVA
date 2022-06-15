package com.example.e_learning;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.e_learning.Container.*;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eLearning.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER + " INTEGER, " +
                QuestionsTable.COLUMN_SUBJECT + " TEXT " + " ); ";
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void fillQuestionsTable() {
        Question question1 = new Question("What is a correct syntax to output \"Hello World\" in Java?", "Console.WriteLine(\"Hello World\");", "System.out.println(\"Hello World\");", "print (\"Hello World\");", "echo(\"Hello World\");", 2, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question1);
        Question question2 = new Question("How do you insert COMMENTS in Java code?", "# This is a comment", "/* This is a comment", "// This is a comment", "<!-- This is a comment -->", 3, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question2);
        Question question3 = new Question("Which data type is used to create a variable that should store text?", "txt", "Text", "string", "String", 4, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question3);
        Question question4 = new Question("How do you create a variable with the numeric value 5?", "x = 5;", "num x = 5", "float x = 5;", "int x = 5;", 4, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question4);
        Question question5 = new Question("How do you create a variable with the floating number 2.8?", "x = 2.8f;", "byte x = 2.8f", "int x = 2.8f;", "float x = 2.8f", 4, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question5);
        Question question6 = new Question("Which method can be used to find the length of a string?", "len()", "getLength()", "length()", "getSize()", 3, Question.SUBJECT_JAVA_METHODS);
        addQuestionToDatabase(question6);
        Question question7 = new Question("To declare an array in Java, define the variable type with:", "( )", "[ ]", "{ }", "< >", 2, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question7);
        Question question8 = new Question("What is the correct way to create an object called myObj of MyClass?", "new myObj = MyClass();", "class myObj = new MyClass();", "class MyClass = new myObj();", "MyClass myObj = new MyClass();", 4, Question.SUBJECT_JAVA_CLASSES);
        addQuestionToDatabase(question8);
        Question question9 = new Question("Which keyword is used to import a package from the Java API library?", "import", "package", "library", "getLibrary", 1, Question.SUBJECT_JAVA_CLASSES);
        addQuestionToDatabase(question9);
        Question question10 = new Question("How do you start writing an if statement in Java?", "if x > y:", "if (x > y)", "if x > y then:", "IF (x > y)", 1, Question.SUBJECT_JAVA_BASICS);
        addQuestionToDatabase(question10);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void addQuestionToDatabase(Question question) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        contentValues.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        contentValues.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        contentValues.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        contentValues.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        contentValues.put(QuestionsTable.COLUMN_ANSWER, question.getAnswer());
        contentValues.put(QuestionsTable.COLUMN_SUBJECT, question.getSubject());
        sqLiteDatabase.insert(QuestionsTable.TABLE_NAME, null, contentValues);
    }

    @SuppressLint("Range")
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                question.setSubject(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_SUBJECT)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }

    @SuppressLint("Range")
    public List<Question> getQuestions(String subject) {
        List<Question> questionList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        String[] selectionArgs = new String[]{subject};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_SUBJECT + " = ? ", selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                question.setSubject(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_SUBJECT)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}