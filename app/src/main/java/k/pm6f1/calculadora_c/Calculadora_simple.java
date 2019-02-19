package k.pm6f1.calculadora_c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import k.pm6f1.calculadora_c.Models.data;

public class Calculadora_simple extends AppCompatActivity {
    //Vars declaration
    int value1, value2;
    public String operation;
    public data object= new data();
    //Views declaration
    EditText et_big, et_small;
    Button btn_c,btn_back, btn_plus, btn_equal, btn_f,
            btn_0,btn_1, btn_2,btn_3,btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_simple);
        //relating views with code, setting onClickListener when it's necesary
        et_big=findViewById(R.id.et_big);
        et_small=findViewById(R.id.et_small);
        btn_f=findViewById(R.id.btn_F);
        btn_f.setOnClickListener(f_activity);
        btn_back= findViewById(R.id.btn_back);
        //Faltan muchos botones de operaciones por agregar
        btn_plus= findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(suma);
        btn_equal= findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(igual);
        //numbers buttons
        btn_0=findViewById(R.id.btn_0);
        btn_0.setOnClickListener(numero_cero);

        btn_1=findViewById(R.id.btn_1);
        btn_1.setOnClickListener(numero_uno);

        btn_2=findViewById(R.id.btn_2);
        btn_2.setOnClickListener(numero_dos);

        btn_3=findViewById(R.id.btn_3);
        btn_3.setOnClickListener(numero_tres);

        btn_4=findViewById(R.id.btn_4);
        btn_4.setOnClickListener(numero_cuatro);

        btn_5=findViewById(R.id.btn_5);
        btn_5.setOnClickListener(numero_cinco);

        btn_6=findViewById(R.id.btn_6);
        btn_6.setOnClickListener(numero_seis);

        btn_7=findViewById(R.id.btn_7);
        btn_7.setOnClickListener(numero_siete);

        btn_8=findViewById(R.id.btn_8);
        btn_8.setOnClickListener(numero_ocho);

        btn_9=findViewById(R.id.btn_9);
        btn_9.setOnClickListener(numero_nueve);
    }
    private View.OnClickListener numero_cero = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("0");
        }
    };
    private View.OnClickListener numero_uno = new View.OnClickListener() {
        public void onClick(View v) {


            et_big.setText("1");


        }
    };
    private View.OnClickListener numero_dos = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("2");
        }
    };
    private View.OnClickListener numero_tres = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("3");
        }
    };
    private View.OnClickListener numero_cuatro = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("4");
        }
    };
    private View.OnClickListener numero_cinco = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("5");
        }
    };
    private View.OnClickListener numero_seis = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("6");
        }
    };
    private View.OnClickListener numero_siete = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("7");
        }
    };
    private View.OnClickListener numero_ocho = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("8");
        }
    };
    private View.OnClickListener numero_nueve = new View.OnClickListener() {
        public void onClick(View v) {
            et_big.setText("9");
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
                            object.getValue_2()* object.getValue_1()));
                }


            } else {
                Toast.makeText(getApplicationContext(), "Viejo lesbiano",Toast.LENGTH_SHORT).show();

            }
        }
    };

    public View.OnClickListener f_activity=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activity_f=new Intent(getApplicationContext(), Cientific_calculator.class);
            startActivity(activity_f);
        }
    };
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


}




