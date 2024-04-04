package com.arnav.memorygames;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

//TODO change button drawable for click button

public class WordsFragment_Selection extends Fragment {
	private static final String TAG = "WordsFragment_Selection";
	final String[] TotalWordsArray = new String[]{"people", "minute", "accord", "evident", "practice", "intent", "conduit",
			"ring", "tent", "scar", "policy", "straight", "stock", "cap", "house", "fancy", "concept", "court", "phone", "passage",
			"vain", "glass", "coast", "project", "history", "art", "world", "map", "level", "family", "floor", "printer", "music",
			"food", "theory", "range", "data", "league", "labor", "law", "bird", "power", "library", "nature", "fact", "yield", "idea",
			"product", "knight", "story", "job", "quality", "skill", "player", "video", "reflect", "novel", "furnish", "exam", "venture", "week",
			"temper", "bent", "physics", "thought", "mayor", "crew", "chamber", "army", "scheme", "camera", "paper", "child", "tide", "attitude",
			"month", "flag", "merit", "manifest", "goal", "news", "formal", "resource", "income", "night", "bat", "ball", "role", "watch"};
	ProgressBar progressBar;
	int count = 0;
	String word;
	Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
			button10, button11, button12, button13, button14, button15, button16, button17, button18;
	ArrayList<String> totalWords;
	Button[] buttonArray;
	Button[] correctButtonArray = new Button[8];
	Button[] incorrectButtonArray = new Button[10];
	String[] UserWords = new String[8];
	String[] words = new String[8];
	String[] incorrectWords = new String[81];
	CountDownTimer countDownTimer;
	int remainingTime;
	TextView progressText;
	Dictionary wordsDictionary = new Hashtable<Button, Object>();
	Random random = new Random();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_words_selection, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

		button1 = requireView().findViewById(R.id.button1);
		button2 = requireView().findViewById(R.id.button2);
		button3 = requireView().findViewById(R.id.button3);
		button4 = requireView().findViewById(R.id.button4);
		button5 = requireView().findViewById(R.id.button5);
		button6 = requireView().findViewById(R.id.button6);
		button7 = requireView().findViewById(R.id.button7);
		button8 = requireView().findViewById(R.id.button8);
		button9 = requireView().findViewById(R.id.button9);
		button10 = requireView().findViewById(R.id.button10);
		button11 = requireView().findViewById(R.id.button11);
		button12 = requireView().findViewById(R.id.button12);
		button13 = requireView().findViewById(R.id.button13);
		button14 = requireView().findViewById(R.id.button14);
		button15 = requireView().findViewById(R.id.button15);
		button16 = requireView().findViewById(R.id.button16);
		button17 = requireView().findViewById(R.id.button17);
		button18 = requireView().findViewById(R.id.button18);

		progressBar = requireView().findViewById(R.id.progressBar);
		progressText = requireView().findViewById(R.id.progressText);

		buttonArray = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9,
				button10, button11, button12, button13, button14, button15, button16, button17, button18};

		assert this.getArguments() != null;
		words = this.getArguments().getStringArray("CorrectWords");

		totalWords = new ArrayList<>();
		totalWords.addAll(Arrays.asList(TotalWordsArray));
		Collections.shuffle(totalWords);


		for (int i = 0; i < 8; i++) {
			int random_int = random.nextInt(17);
			correctButtonArray[i] = buttonArray[random_int];
		}

		for (Button i : buttonArray) {
			int x = 0;
			if (belongsTo(i)) {
			} else {
				incorrectButtonArray[x] = i;
				x++;
			}
		}

		for (String i : TotalWordsArray) {
			int x2 = 0;
			if (belongsToWords(i)) {
			} else {
				incorrectWords[x2] = i;
				x2++;
			}
		}

		for (int x = 0; x < 18; x++) {
			word = TotalWordsArray[random.nextInt(88)];
			wordsDictionary.put(buttonArray[x], word);
			buttonArray[x].setText(word);
		}

		for (int j = 0; j < 8; j++) {
			wordsDictionary.remove(correctButtonArray[j]);
			wordsDictionary.put(correctButtonArray[j], String.valueOf(words[j]));
			correctButtonArray[j].setText(words[j]);
		}

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button1));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button2));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button3));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button4));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button5));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button6));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button7));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button8));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button9));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button10));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button11));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button12));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button13));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button14));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button15));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button16));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button17));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		button18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UserWords[count] = String.valueOf(wordsDictionary.get(button18));
				count++;
				if (count >= 8) {
					FragmentManager manager = requireActivity().getSupportFragmentManager();
					FragmentTransaction transaction = manager.beginTransaction();
					WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
					transaction.replace(R.id.frameLayout, WordsFragmentStart);
					transaction.commit();
				}
			}
		});
		countDownTimer = new CountDownTimer(20000, 10) {
			@Override
			public void onTick(long millisUntilFinished) {
				remainingTime = (int) millisUntilFinished / 1000;
				int progress = (int) millisUntilFinished / 200;
				progressText.setText(String.valueOf(remainingTime + 1));
				progressBar.setProgress(progress, false);
			}

			@Override
			public void onFinish() {
				progressText.setText("Time Up");
				FragmentManager manager = requireActivity().getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				WordsFragment_Start WordsFragmentStart = new WordsFragment_Start();
				transaction.replace(R.id.frameLayout, WordsFragmentStart);
				transaction.commit();
			}
		};
		countDownTimer.start();

		super.onViewCreated(view, savedInstanceState);
	}

	//public boolean contains(Button givenValue){
	//      Boolean found = false;
	//    for(Button x : correctButtonArray){
	//      if (x == givenValue){
	//        found = true;
	//  }
	//}
	//return found;
//}
	public boolean belongsTo(Button givenValue) {
		boolean condition = givenValue == correctButtonArray[0];
		if (givenValue == correctButtonArray[1]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[2]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[3]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[4]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[5]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[6]) {
			condition = true;
		}
		if (givenValue == correctButtonArray[7]) {
			condition = true;
		}
		return condition;
	}

	public Boolean belongsToWords(String Given) {
		Boolean condition2 = false;
		if (words[0] == Given) {
			condition2 = true;
		}
		if (words[1] == Given) {
			condition2 = true;
		}
		if (words[2] == Given) {
			condition2 = true;
		}
		if (words[3] == Given) {
			condition2 = true;
		}
		if (words[4] == Given) {
			condition2 = true;
		}
		if (words[5] == Given) {
			condition2 = true;
		}
		if (words[6] == Given) {
			condition2 = true;
		}
		if (words[7].equals(Given)) {
			condition2 = true;
		}

		return condition2;
	}
}
