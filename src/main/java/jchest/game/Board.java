package jchest.game;

public class Board {

    public enum PieceType {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN;
    }

    public enum Side {
        WHITE,
        BLACK;
    }

    public enum Piece {
        WK (Side.WHITE, PieceType.KING, 'K'),
        WQ (Side.WHITE, PieceType.QUEEN, 'Q'),
        WR (Side.WHITE, PieceType.ROOK, 'R'),
        WB (Side.WHITE, PieceType.BISHOP, 'B'),
        WN (Side.WHITE, PieceType.KNIGHT, 'N'),
        WP (Side.WHITE, PieceType.PAWN, 'P'), 
        BK (Side.BLACK, PieceType.KING, 'k'),
        BQ (Side.BLACK, PieceType.QUEEN, 'q'),
        BR (Side.BLACK, PieceType.ROOK, 'r'),
        BB (Side.BLACK, PieceType.BISHOP, 'b'),
        BN (Side.BLACK, PieceType.KNIGHT, 'n'),
        BP (Side.BLACK, PieceType.PAWN, 'p');

        private final Side side;
        private final PieceType type;
        private final char pchar;

        private Piece(Side side, PieceType type, char pchar) {
            this.side = side;
            this.type = type;
            this.pchar = pchar;
        }

        public Side side() {
            return side;
        }

        public PieceType type() {
            return type;
        }

        public char pchar() {
            return pchar;
        }
    }

    public enum Direction {
        E,
        NE,
        N,
        NW,
        W,
        SW,
        S,
        SE;
    }

    // 0 == A1
    private Piece[] pieces;
    
    public Board() {
        pieces = new Piece[64];
    }

    public void put(int i, Piece p) {
        pieces[i] = p;
    }

    public void newGame() {
        pieces[0] = Piece.WR;
        pieces[1] = Piece.WN;
        pieces[2] = Piece.WB;
        pieces[3] = Piece.WQ;
        pieces[4] = Piece.WK;
        pieces[5] = Piece.WB;
        pieces[6] = Piece.WN;
        pieces[7] = Piece.WR;
        
        pieces[56] = Piece.BR;
        pieces[57] = Piece.BN;
        pieces[58] = Piece.BB;
        pieces[59] = Piece.BQ;
        pieces[60] = Piece.BK;
        pieces[61] = Piece.BB;
        pieces[62] = Piece.BN;
        pieces[63] = Piece.BR;

        for (int i = 0; i < 8; i++) {
            pieces[8+i] = Piece.WP;
            pieces[48+i] = Piece.BP;
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = pieces[8*(7-i) + j];
                if (p == null) s += ".";
                else s += p.pchar();
                s += ' ';
            }
            s += '\n';
        }
        return s;
    }

}