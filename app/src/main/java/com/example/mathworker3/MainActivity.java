package com.example.mathworker3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathworker3.databinding.ActivityMainBinding;
import com.example.mathworker3.R;
import com.example.mathworker3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Problem problem=new Problem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        generateProblem();
        MyClickListener listener = new MyClickListener();
        binding.next.setOnClickListener(listener);
        binding.solution1.setOnClickListener(listener);
        binding.solution2.setOnClickListener(listener);
        binding.solution3.setOnClickListener(listener);
        binding.solution4.setOnClickListener(listener);
        binding.solution5.setOnClickListener(listener);
        binding.solution6.setOnClickListener(listener);
    }
    private void generateProblem() {
        int position = problem.getRandom(1, 6)+1;
        binding.title.setTextColor(getColor((R.color.textcolor)));
        Shader textShadertitle = new LinearGradient(0, 0, binding.title.getPaint().measureText(String.valueOf(binding.title.getText())), binding.title.getTextSize(),
                new int[]{
                        getColor(R.color.correct),
                        getColor(R.color.graykitty)
                }, null, Shader.TileMode.CLAMP);
        binding.title.getPaint().setShader(textShadertitle);
        binding.problem.setText(String.valueOf(problem.getProblem()));
        binding.problem.setTextColor(getColor((R.color.red_rainbow)));
        Shader textShader = new LinearGradient(0, 0, binding.problem.getPaint().measureText(String.valueOf(binding.problem.getText())), binding.problem.getTextSize(),
                new int[]{
                        getColor(R.color.red_rainbow),
                        getColor(R.color.orange_rainbow),
                        getColor(R.color.yellow_rainbow),
                        getColor(R.color.green_rainbow),
                        getColor(R.color.blue_rainbow),
                        getColor(R.color.violet_rainbow),
                }, null, Shader.TileMode.CLAMP);
        binding.problem.getPaint().setShader(textShader);
        binding.solution1.setBackgroundColor(getColor(R.color.incorrect));
        binding.solution2.setBackgroundColor(getColor(R.color.incorrect));
        binding.solution3.setBackgroundColor(getColor(R.color.incorrect));
        binding.solution4.setBackgroundColor(getColor(R.color.incorrect));
        binding.solution5.setBackgroundColor(getColor(R.color.incorrect));
        binding.solution6.setBackgroundColor(getColor(R.color.incorrect));
        switch (position) {
            case 1:
                binding.solution1.setText(String.valueOf(problem.getResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution4.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution5.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution6.setText(String.valueOf(problem.getNoiseResult()));break;
            case 2:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution4.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution5.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution6.setText(String.valueOf(problem.getNoiseResult())); break;
            case 3:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getResult()));
                binding.solution4.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution5.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution6.setText(String.valueOf(problem.getNoiseResult()));  break;
            case 4:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution4.setText(String.valueOf(problem.getResult()));
                binding.solution5.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution6.setText(String.valueOf(problem.getNoiseResult()));break;
            case 5:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution4.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution5.setText(String.valueOf(problem.getResult()));
                binding.solution6.setText(String.valueOf(problem.getNoiseResult())); break;
            case 6:
                binding.solution1.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution2.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution3.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution4.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution5.setText(String.valueOf(problem.getNoiseResult()));
                binding.solution6.setText(String.valueOf(problem.getResult())); break;
        }
    }
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.next:
                    generateProblem(); break;
                case R.id.solution1:
                case R.id.solution2:
                case R.id.solution3:
                case R.id.solution4:
                case R.id.solution5:
                case R.id.solution6:
                    String text=((TextView) view).getText().toString();
                    if (text.equals(String.valueOf(problem.getResult()))){
                        view.setBackgroundColor(getColor(R.color.correct));
                        Toast.makeText(MainActivity.this,"Правильно!",Toast.LENGTH_LONG).show();
                    }
                    else{
                        view.setBackgroundColor(getColor(R.color.incorrect));
                        Toast.makeText(MainActivity.this,"Ужас!",Toast.LENGTH_LONG).show();
                    } break;
            }
        }
    }
}