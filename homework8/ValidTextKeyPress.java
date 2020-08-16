package edu.nyu.cs9053.homework8;

public enum ValidTextKeyPress {

    Two('a','b','c','A', 'B', 'C'),
    Three('d','e','f', 'D', 'E', 'F'),
    Four('g','h','i', 'G', 'H', 'I'),
    Five('j','k','l', 'J', 'K', 'L'),
    Six('m','n','o', 'M', 'N', 'O'),
    Seven('p','q','r','s', 'P', 'Q', 'R', 'S'),
    Eight('t','u','v', 'T', 'U', 'V'),
    Nine('w','x','y','z', 'W', 'X', 'Y', 'Z');

    Character[] chars;

    ValidTextKeyPress(Character... ch) { this.chars = ch; }

    public Character[] getCharacters() { return chars; }
}

