package dev.webfx.platform.ast.yaml.parser.javacup;

import java_cup.runtime.Symbol;

import java.util.List;

/**
 * @author Bruno Salmon
 */
public class MultipleSymbol extends Symbol {

    private final Symbol[] symbols;
    private int nextSymbolIndex;

    public MultipleSymbol(Symbol... symbols) {
        super(0, null);
        this.symbols = symbols;
    }

    Symbol nextSymbol() {
        if (nextSymbolIndex >= symbols.length)
            return null;
        return symbols[nextSymbolIndex++];
    }

    public static Symbol repeatedSymbol(int count, int id) {
        return repeatedSymbol(count, id, null);
    }

    public static Symbol repeatedSymbol(int count, int id, Object o) {
        if (count == 1)
            return new Symbol(id, o);
        Symbol[] symbols = new Symbol[count];
        for (int i = 0; i < count; i++)
            symbols[i] = new Symbol(id, o);
        return new MultipleSymbol(symbols);
    }

    public static Symbol ofList(List<Symbol> symbols) {
        if (symbols.size() == 1)
            return symbols.get(0);
        return new MultipleSymbol(symbols.toArray(new Symbol[0]));
    }

    public static Symbol repeatedSymbolThenSymbol(int count, int id, Symbol symbol) {
        return repeatedSymbolThenSymbol(count, id, null, symbol);
    }

    public static Symbol repeatedSymbolThenSymbol(int count, int id, Object o, Symbol symbol) {
        if (count == 0)
            return symbol;
        MultipleSymbol ms = (MultipleSymbol) repeatedSymbol(count + 1, id, o);
        ms.symbols[count] = symbol;
        return ms;
    }

}
