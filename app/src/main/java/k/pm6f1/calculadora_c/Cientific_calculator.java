package k.pm6f1.calculadora_c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import k.pm6f1.calculadora_c.Functions.ofdata;
import k.pm6f1.calculadora_c.Models.data;

public class Cientific_calculator extends AppCompatActivity {

    EditText et_big, et_small;
    //Variables utilizadas
    String operation;
    public double result;
    //Objects utilizaded
    public data object= new data();
    public ofdata data_functions= new ofdata();
    //functions buttons
    Button btn_c,btn_back, btn_plus, btn_equal, btn_f, btn_less, btn_x, btn_div;
    //scientic buttons
    Button btn_yx_2, btn_reciproc, btn_root, btn_enesim, btn_log, btn_ln, btn_ex, btn_10x; //Faltan botones
    //Button numbers
    Button btn_0,btn_1, btn_2,btn_3,btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9;
    //resources
    Toast Error_mesage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cientific_calculator);
        Error_mesage= Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
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

        //btn_yx_2, btn_reciproc, btn_root, btn_enesim, btn_log, btn_ln, btn_ex, btn_10x;
        btn_yx_2=findViewById(R.id.small_btn_yx_2);
        btn_reciproc=findViewById(R.id.small_btn_xsurprised);
        btn_root=findViewById(R.id.small_btn_x2);
        btn_enesim=findViewById(R.id.small_btn_yx);
        btn_log=findViewById(R.id.small_btn_LNx10);
        btn_ln=findViewById(R.id.small_btn_LN);
        btn_ex=findViewById(R.id.small_btn_ex);
        btn_10x=findViewById(R.id.small_btn_10x);



        btn_yx_2.setOnClickListener(yx);
        btn_reciproc.setOnClickListener(reciproc);
        btn_root.setOnClickListener(root);
        btn_enesim.setOnClickListener(enesim);
        btn_log.setOnClickListener(log);
        btn_ln.setOnClickListener(ln);
        btn_ex.setOnClickListener(Ex);
        btn_10x.setOnClickListener(tenx);


        btn_0=findViewById(R.id.small_btn_cero);
        btn_1=findViewById(R.id.small_btn_one);
        btn_2=findViewById(R.id.small_btn_two);
        btn_3=findViewById(R.id.small_btn_tree);
        btn_4=findViewById(R.id.small_btn_four);
        btn_5=findViewById(R.id.small_btn_five);
        btn_6=findViewById(R.id.small_btn_six);
        btn_7=findViewById(R.id.small_btn_seven);
        btn_8=findViewById(R.id.small_btn_eigth);
        btn_9=findViewById(R.id.small_btn_nine);

        btn_0.setOnClickListener(numero_cero);
        btn_1.setOnClickListener(numero_uno);
        btn_2.setOnClickListener(numero_dos);
        btn_3.setOnClickListener(numero_tres);
        btn_4.setOnClickListener(numero_cuatro);
        btn_5.setOnClickListener(numero_cinco);
        btn_6.setOnClickListener(numero_seis);
        btn_7.setOnClickListener(numero_siete);
        btn_8.setOnClickListener(numero_ocho);
        btn_9.setOnClickListener(numero_nueve);



    }

    public void add_input(char input_type){
        String EditText_Value=et_big.getText().toString();
        EditText_Value= data_functions.add_numbers(input_type,EditText_Value);
        et_big.setText(EditText_Value);
    }


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

        //Cientific operations
        public View.OnClickListener yx = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                operation = "yx";

            }
        };
        public View.OnClickListener reciproc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    save_value(1);
                    result = 1.00 / object.value_1;

                    Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();
                    et_big.setText(String.valueOf(result));

                    operation = "reciproc";
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                }
                }
        };
        public View.OnClickListener root = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                result=Math.sqrt(object.getValue_1());//insert operation here
                et_big.setText(Double.toString(result));
                operation = "root";
            }
        };
        public View.OnClickListener enesim = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                operation = "enesim";

            }
        };
        public View.OnClickListener log = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                result= Math.log10(object.value_1);
                Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();
                et_big.setText(String.valueOf(result));
                operation = "log";

            }
        };
        public View.OnClickListener ln = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                result= Math.log(object.value_1);
                Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();
                et_big.setText(String.valueOf(result));
                operation = "ln";

            }
        };
        public View.OnClickListener Ex = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double e=Math.E;
                save_value(1);
                result= Math.pow(e,object.value_1);
                Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();
                et_big.setText(String.valueOf(result));
                operation = "ex";

            }
        };
        public View.OnClickListener tenx = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value(1);
                result= Math.pow(10,object.value_1);
                Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();
                et_big.setText(String.valueOf(result));
                operation = "10x";

            }
        };






    public View.OnClickListener igual= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                switch (operation){//Operation methods
                    //scientific cases "reciproc", "root", "log",
                    // "ln", "ex", and "10x" don't need to be her
                    //they act by themself in the OnClick Method
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
                    case "yx":
                        save_value(2);
                        result=Math.pow(object.value_1,object.value_2 );
                        et_big.setText(String.valueOf(result));
                        break;
                    case "enesim":
                        save_value(2);
                        result =Math.pow(object.value_2, (1/object.value_1));//i THANK YO MATH IV
                        et_big.setText(String.valueOf(result));
                        break;


                    default:
                        et_big.setText("");
                        break;
                }

            }
            catch (Exception e){
                Error_mesage.show();
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
}
