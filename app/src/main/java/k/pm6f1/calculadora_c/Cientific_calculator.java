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
    String operation;
    public data object= new data();
    public double result;
    //functions buttons
    Button btn_c,btn_back, btn_plus, btn_equal, btn_f, btn_less, btn_x, btn_div;
    //scientic buttons
    Button btn_yx_2, btn_reciproc, btn_root, btn_enesim, btn_log, btn_ln, btn_ex, btn_10x; //Faltan botones
    //Button numbers
    Button btn_0,btn_1, btn_2,btn_3,btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9;


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


        public View.OnClickListener less = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "resta";
            }
        };
        public View.OnClickListener multi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "multi";

            }
        };
        public View.OnClickListener div = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "divi";

            }
        };

        private View.OnClickListener suma = new View.OnClickListener() {
            public void onClick(View v) {

                save_value();
                operation = "suma";

            }
        };

        //Cientific operations
        public View.OnClickListener yx = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "yx";

            }
        };
        public View.OnClickListener reciproc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //save_value();
                    result = 1 / 4;
                    Toast.makeText(getApplicationContext(), ""+ result, Toast.LENGTH_SHORT).show();


                    operation = "reciproc";
                } catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                }
                }
        };
        public View.OnClickListener root = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                result=Math.sqrt(object.getValue_1());//insert operation here
                et_big.setText(Double.toString(result));
                operation = "root";
            }
        };
        public View.OnClickListener enesim = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "enesim";

            }
        };
        public View.OnClickListener log = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "log";

            }
        };
        public View.OnClickListener ln = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "ln";

            }
        };
        public View.OnClickListener Ex = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "ex";

            }
        };
        public View.OnClickListener tenx = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_value();
                operation = "10x";

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

            if (isNumeric(introduced_txt)) {

                if(operation.equals("suma")) {
                    save_value2();
                    et_big.setText(Integer.toString(object.getValue_2() + object.getValue_1()));
                }
                if (operation.equals("resta")){
                    save_value2();
                    et_big.setText(Integer.toString(object.getValue_2() - object.getValue_2()));
                }
                if (operation.equals("multi")){
                    save_value2();
                    et_big.setText(Integer.toString(
                            object.getValue_2()* object.getValue_1()));
                }

                if (operation.equals("divi")){
                    save_value2();
                    et_big.setText(Integer.toString(
                            object.getValue_2() / object.getValue_1()));
                }
                if(operation.equals("yx")){
                    save_value2();
                    result=Math.pow(object.getValue_1(),object.getValue_2());;//insert operation here
                    et_big.setText(Double.toString(result));
                }
                if(operation.equals("reciproc")){
                    result=1/object.getValue_1();
                    et_big.setText(Double.toString(result));
            }
                if(operation.equals("root")){
                    result=Math.sqrt(object.getValue_1());//insert operation here
                    et_big.setText(Double.toString(result));
                }

                //Math.pow(16,1.0/4)=2
                if(operation.equals("enesim")){
                    save_value2();
                    result =Math.pow(object.getValue_1(), 1.0/object.getValue_2());//insert operation here
                    et_big.setText(Double.toString(result));
                }
                if(operation.equals("log")){
                    result= (Math.log10(object.getValue_1()) / Math.log10(10));//insert operation here
                    et_big.setText(Double.toString(result));
                }
                if(operation.equals("ln")){
                    double e = 2.718282;
                    result= (Math.log10(object.getValue_1()) / Math.log10(e));//insert operation here
                    et_big.setText(Double.toString(result));
                }
                if(operation.equals("ex")){
                    double e = 2.718282;
                    result=Math.pow(e, object.getValue_1());//insert operation here
                    et_big.setText(Double.toString(result));
                }
                if(operation.equals("10x")){
                    result=(Math.pow(10, object.getValue_1()));
                    //insert operation here
                    et_big.setText(Double.toString(result));
                }

            } else {
                Toast.makeText(getApplicationContext(), "Viejo lesbiano",Toast.LENGTH_SHORT).show();

            }
        }
    };

    public boolean save_value2(){
        boolean result;
        int val=Integer.valueOf(
                et_big.getText().toString());
        String introduced_txt=et_big.getText().toString();

        if (isNumeric(introduced_txt) == true) {

            object.setValue_2(val);
            et_small.setText(Integer.toString(object.getValue_1()));

            Toast.makeText(getApplicationContext(), "Added value 2 & 1: "+object.getValue_1() + "," +object.getValue_2(), Toast.LENGTH_SHORT).show();

            result=true;

        } else {
            Toast.makeText(getApplicationContext(), "Viejo lesbiano",Toast.LENGTH_SHORT).show();
            result= false;
        }
        return result;
    }


    //bottom programation
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
}
