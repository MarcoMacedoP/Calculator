package k.pm6f1.calculadora_c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import k.pm6f1.calculadora_c.Models.data;

public class Cientific_calculator extends AppCompatActivity {

    EditText et_big, et_small;
    //Variables utilizadas
    String operation; public data object= new data();
    //functions buttons
    Button btn_c,btn_back, btn_plus, btn_equal, btn_f, btn_less, btn_x, btn_div;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cientific_calculator);
        et_big= findViewById(R.id.et_big2);
        et_small=findViewById(R.id.et_small2);

        btn_c=findViewById(R.id.small_btn_c);
        btn_back=findViewById(R.id.small_btn_back);
        btn_plus=findViewById(R.id.small_btn_more);
        btn_equal=findViewById(R.id.small_btn_equals);
        btn_f=findViewById(R.id.small_btn_f);
        btn_less=findViewById(R.id.small_btn_less);
        btn_x=findViewById(R.id.small_btn_x);
        btn_div=findViewById(R.id.small_btn_div);

        btn_plus.setOnClickListener(suma);
        btn_equal.setOnClickListener(igual);
        btn_less.setOnClickListener(less);
        btn_x.setOnClickListener(multi);
        btn_div.setOnClickListener(div);

    }
    public View.OnClickListener less= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value();
            operation="resta";

        }
    };
    public View.OnClickListener multi= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value();
            operation="multi";

        }
    };
    public View.OnClickListener div= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value();
            operation="divi";

        }
    };

    private View.OnClickListener suma = new View.OnClickListener(){
        public void onClick(View v) {

            save_value();
            operation="suma";

        }
    };


    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    public boolean save_value(){
        boolean result;
        int val=Integer.valueOf(
                et_big.getText().toString());
        String introduced_txt=et_big.getText().toString();

        if (isNumeric(introduced_txt) == true) {


            object.setValue_1(val);
            et_small.setText(Integer.toString(object.getValue_1()));

            Toast.makeText(getApplicationContext(), "Added value 1: "+object.getValue_1(), Toast.LENGTH_SHORT).show();
            et_big.setText("");
            result=true;

        } else {
            Toast.makeText(getApplicationContext(), "Viejo lesbiano",Toast.LENGTH_SHORT).show();
            result= false;
        }
        return result;
    }
    public View.OnClickListener igual= new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String introduced_txt=et_big.getText().toString();

            if (isNumeric(introduced_txt) == true) {
                int val=Integer.valueOf(
                        et_big.getText().toString());

                object.setValue_2(val);
                et_small.setText(Integer.toString(object.getValue_1()));

                Toast.makeText(getApplicationContext(), "Added value 2 & 1: "+object.getValue_1() + "," +object.getValue_2(), Toast.LENGTH_SHORT).show();

                if(operation.equals("suma")) {
                    et_big.setText(Integer.toString(object.getValue_2() + object.getValue_1()));
                }
                if (operation.equals("resta")){
                    et_big.setText(Integer.toString(object.getValue_2() - object.getValue_2()));
                }
                if (operation.equals("multi")){
                    et_big.setText(Integer.toString(
                            object.getValue_2()* object.getValue_1()));
                }

                if (operation.equals("divi")){
                    et_big.setText(Integer.toString(
                            object.getValue_2() / object.getValue_1()));
                }


            } else {
                Toast.makeText(getApplicationContext(), "Viejo lesbiano",Toast.LENGTH_SHORT).show();

            }
        }
    };

}
