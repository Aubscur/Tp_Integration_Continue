package com.froyo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Trivia {

	private static final Logger logger = LoggerFactory.getLogger(Trivia.class);

	ArrayList<String> players = new ArrayList<>();
	int[] places = new int[6];
	int[] purses = new int[6];
	boolean[] inPenaltyBox = new boolean[6];

	static final String SPORTS = "Sports";
	static final String ROCK = "Rock";
	static final String SCIENCE = "Science";
	static final String POP = "Pop";
	String res;
	LinkedList<String> popQuestions = new LinkedList<>();
	LinkedList<String> scienceQuestions = new LinkedList<>();
	LinkedList<String> sportsQuestions = new LinkedList<>();
	LinkedList<String> rockQuestions = new LinkedList<>();

	int currentPlayer = 0;
	boolean isGettingOutOfPenaltyBox;

	public Trivia() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
		}
	}

	public String createRockQuestion(int index) {
		return "Rock Question " + index;
	}

	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {

		players.add(playerName);
		places[howManyPlayers()] = 0;
		purses[howManyPlayers()] = 0;
		inPenaltyBox[howManyPlayers()] = false;
		res = playerName + " was added";
		logger.info(res);
		logger.info("They are player number {}", players.size());
		return true;
	}

	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		logger.info("{} is the current player", players.get(currentPlayer));
		logger.info("They have rolled a {}", roll);

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				logger.info("{} is getting out of the penalty box", players.get(currentPlayer));
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 11)
					places[currentPlayer] = places[currentPlayer] - 12;

				logger.info("{}'s new location is {}", players.get(currentPlayer), places[currentPlayer]);
				res = "The category is {}" + currentCategory();
				logger.info(res);
				askQuestion();
			} else {
				logger.info("{} is not getting out of the penalty box", players.get(currentPlayer));
				isGettingOutOfPenaltyBox = false;
			}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11)
				places[currentPlayer] = places[currentPlayer] - 12;

			logger.info("{}'s new location is {}", players.get(currentPlayer), places[currentPlayer]);
			res = "The category is " + currentCategory();
			logger.info(res);
			askQuestion();
		}

	}

	private void askQuestion() {
		if (currentCategory().equals(POP))
			res = popQuestions.removeFirst();
		logger.info(res);
		if (currentCategory().equals(SCIENCE))
			res = scienceQuestions.removeFirst();
		logger.info(res);
		if (currentCategory().equals(SPORTS))
			res = sportsQuestions.removeFirst();
		logger.info(res);
		if (currentCategory().equals(ROCK))
			res = rockQuestions.removeFirst();
		logger.info(res);
	}

	private String currentCategory() {
		if (places[currentPlayer] == 0)
			return POP;
		if (places[currentPlayer] == 4)
			return POP;
		if (places[currentPlayer] == 8)
			return POP;
		if (places[currentPlayer] == 1)
			return SCIENCE;
		if (places[currentPlayer] == 5)
			return SCIENCE;
		if (places[currentPlayer] == 9)
			return SCIENCE;
		if (places[currentPlayer] == 2)
			return SPORTS;
		if (places[currentPlayer] == 6)
			return SPORTS;
		if (places[currentPlayer] == 10)
			return SPORTS;
		return ROCK;
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]) {
			if (isGettingOutOfPenaltyBox) {
				logger.info("Answer was correct!!!!");
				purses[currentPlayer]++;
				logger.info("{} now has {} Gold Coins.", players.get(currentPlayer), purses[currentPlayer]);

				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size())
					currentPlayer = 0;

				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size())
					currentPlayer = 0;
				return true;
			}

		} else {

			logger.info("Answer was corrent!!!!");
			purses[currentPlayer]++;
			logger.info("{} now has {} Gold Coins.", players.get(currentPlayer), purses[currentPlayer]);

			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size())
				currentPlayer = 0;

			return winner;
		}
	}

	public boolean wrongAnswer() {
		logger.info("Question was incorrectly answered");
		logger.info("{} was sent to the penalty box", players.get(currentPlayer));
		inPenaltyBox[currentPlayer] = false;

		currentPlayer++;
		if (currentPlayer == players.size()) {
			currentPlayer = 0;
		}

		return true;
	}

	private boolean didPlayerWin() {
		return (purses[currentPlayer] != 6);
	}
}
