package k.pm6f1.calculadora_c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import k.pm6f1.calculadora_c.Functions.ofdata;
import k.pm6f1.calculadora_c.Models.data;

public class Calculadora_simple extends AppCompatActivity {
    //Vars declaration
    int value1, value2;
    public String operation;
    double result;
    //objects
    public data object = new data();
    public ofdata data_functions= new ofdata();
    //Views declaration
    EditText et_big, et_small;
    //numbers buttons
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6,
            btn_7, btn_8, btn_9;
    //functions buttons
    Button btn_c, btn_back, btn_plus, btn_equal, btn_f, btn_less, btn_x, btn_div, btn_dot, btn_clean, btn_del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_simple);
        //relating views with code, setting onClickListener when it's necesary
        et_big = findViewById(R.id.et_big);
        et_small = findViewById(R.id.et_small);
        btn_f = findViewById(R.id.btn_F);
        btn_f.setOnClickListener(f_activity);
        btn_back = findViewById(R.id.btn_delete);
        //Faltan muchos botones de operaciones por agregar
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(suma);
        btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(igual);
        btn_less = findViewById(R.id.btn_less);
        btn_less.setOnClickListener(less);
        btn_x = findViewById(R.id.btn_x);
        btn_x.setOnClickListener(multi);
        btn_div = findViewById(R.id.btn_div);
        btn_div.setOnClickListener(div);
        btn_dot=findViewById(R.id.btn_dot);
        btn_dot.setOnClickListener(dot);
        btn_clean=findViewById(R.id.btn_c);
        btn_clean.setOnClickListener(clean);
        btn_del=findViewById(R.id.btn_delete);
        btn_del.setOnClickListener(del);

        //numbers buttons
        btn_0 = findViewById(R.id.btn_0);
        btn_0.setOnClickListener(numero_cero);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(numero_uno);

        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(numero_dos);

        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(numero_tres);

        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(numero_cuatro);

        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(numero_cinco);

        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(numero_seis);

        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(numero_siete);

        btn_8 = findViewById(R.id.btn_8);
        btn_8.setOnClickListener(numero_ocho);

        btn_9 = findViewById(R.id.btn_9);
        btn_9.setOnClickListener(numero_nueve);
    }

    public View.OnClickListener f_activity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent activity_f = new Intent(getApplicationContext(), Cientific_calculator.class);
            startActivity(activity_f);
        }
    };

    public View.OnClickListener clean = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            data_functions.clean(et_big, et_small);
        }
    };
    public View.OnClickListener del = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                String actual_EditText=et_big.getText().toString();
                actual_EditText= data_functions.remove(actual_EditText);
                et_big.setText(actual_EditText);
                Toast.makeText(getApplicationContext(), "Bien",Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Mal",Toast.LENGTH_SHORT).show();
            }

        }
    };
    //Operations, send a value to String operation that is going to be compared in the equal method.
    public View.OnClickListener less = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value(1);
            operation = "-";

        }
    };
    public View.OnClickListener multi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value(1);
            operation = "*";

        }
    };
    public View.OnClickListener div = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_value(1);
            operation = "/";

        }
    };

    private View.OnClickListener suma = new View.OnClickListener() {
        public void onClick(View v) {

            save_value(1);
            operation = "+";

        }
    };




    public View.OnClickListener igual = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                switch (operation) {//Operation methods

                case "+":
                    save_value(2);
                    result = object.value_1 + object.value_2;
                    et_big.setText(String.valueOf(result));
                    break;
                case "-":
                    save_value(2);
                    result = object.value_1 - object.value_2;
                    et_big.setText(String.valueOf(result));
                    break;
                case "*":
                    save_value(2);
                    result = object.value_1 * object.value_2;
                    et_big.setText(String.valueOf(result));
                    break;
                case "/":
                    save_value(2);
                    result = object.value_1 / object.value_2;
                    et_big.setText(String.valueOf(result));
                    break;
                default:
                    et_big.setText("");
                    break;
            }

            }
            catch (Exception e){
                et_big.setText("");
            }
            }
        };


        public void save_value(int val_number) {
           try {
               double actual_val = Double.valueOf(et_big.getText().toString());

               switch (val_number) {

                   case 1:

                       object.setValue_1(actual_val);
                       et_small.setText(String.valueOf(object.getValue_1()));
                       et_big.setText("");
                       Toast.makeText(getApplicationContext(), "Added value 1: " + object.getValue_1(), Toast.LENGTH_SHORT).show();
                       break;
                   case 2:
                       object.setValue_2(actual_val);
                       et_small.setText(String.valueOf(object.getValue_1()));
                       et_big.setText("");
                       Toast.makeText(getApplicationContext(), "Added value 2: " + object.getValue_2(), Toast.LENGTH_SHORT).show();

                       break;
                   default:
                       //ins
                       break;
               }
            }
           catch(Exception e){
               Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

           }

        }







        //bottom programation
    private View.OnClickListener numero_cero = new View.OnClickListener() {
        public void onClick(View v) {
            char input='0';
            add_input(input);
        }
    };
    private View.OnClickListener numero_uno = new View.OnClickListener() {
        public void onClick(View v) {
            char input='1';
            add_input(input);
        }
    };
    private View.OnClickListener numero_dos = new View.OnClickListener() {
        public void onClick(View v) {
            char input='2';
            add_input(input);
        }
    };
    private View.OnClickListener numero_tres = new View.OnClickListener() {
        public void onClick(View v) {
            char input='3';
            add_input(input);
        }
    };
    private View.OnClickListener numero_cuatro = new View.OnClickListener() {
        public void onClick(View v) {
            char input='4';
            add_input(input);
        }
    };
    private View.OnClickListener numero_cinco = new View.OnClickListener() {
        public void onClick(View v) {
            char input='5';
            add_input(input);
        }
    };
    private View.OnClickListener numero_seis = new View.OnClickListener() {
        public void onClick(View v) {
            char input='6';
            add_input(input);
        }
    };
    private View.OnClickListener numero_siete = new View.OnClickListener() {
        public void onClick(View v) {
            char input='7';
            add_input(input);
        }
    };
    private View.OnClickListener numero_ocho = new View.OnClickListener() {
        public void onClick(View v) {
            char input='8';
            add_input(input);
        }
    };
    private View.OnClickListener numero_nueve = new View.OnClickListener() {
        public void onClick(View v) {
            char input='9';
            add_input(input);
        }
    };
    public View.OnClickListener dot = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            char input='.';
            add_input(input);
        }
    };
    public void add_input(char input_type){
        String EditText_Value=et_big.getText().toString();
        EditText_Value= data_functions.add_numbers(input_type,EditText_Value);
        et_big.setText(EditText_Value);
    }
}



