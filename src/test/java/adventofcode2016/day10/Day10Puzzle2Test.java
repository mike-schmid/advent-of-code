package adventofcode2016.day10;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Mike Schmid
 */
public class Day10Puzzle2Test {

    @Test
    public void solve() throws Exception {

        final String input = "value 5 goes to bot 2\n" +
                "bot 2 gives low to bot 1 and high to bot 0\n" +
                "value 3 goes to bot 1\n" +
                "bot 1 gives low to output 1 and high to bot 0\n" +
                "bot 0 gives low to output 2 and high to output 0\n" +
                "value 2 goes to bot 2";

        Assert.assertEquals(5 * 2 * 3, Day10Puzzle2.solve(input));
    }

    @Test
    public void solveReal() throws Exception {

        final String input = "bot 135 gives low to bot 27 and high to bot 166\n" +
                "bot 57 gives low to bot 4 and high to bot 186\n" +
                "bot 115 gives low to output 2 and high to bot 80\n" +
                "bot 44 gives low to bot 175 and high to bot 88\n" +
                "bot 167 gives low to bot 42 and high to bot 168\n" +
                "bot 18 gives low to bot 32 and high to bot 89\n" +
                "bot 199 gives low to bot 75 and high to bot 40\n" +
                "bot 129 gives low to bot 178 and high to bot 147\n" +
                "bot 163 gives low to bot 49 and high to bot 160\n" +
                "value 2 goes to bot 143\n" +
                "bot 176 gives low to bot 139 and high to bot 117\n" +
                "bot 194 gives low to bot 11 and high to bot 37\n" +
                "bot 99 gives low to bot 163 and high to bot 138\n" +
                "value 53 goes to bot 9\n" +
                "bot 159 gives low to output 1 and high to bot 207\n" +
                "bot 0 gives low to bot 105 and high to bot 13\n" +
                "bot 6 gives low to bot 66 and high to bot 116\n" +
                "bot 81 gives low to bot 54 and high to bot 10\n" +
                "bot 27 gives low to bot 188 and high to bot 199\n" +
                "bot 186 gives low to bot 84 and high to bot 123\n" +
                "bot 154 gives low to bot 21 and high to bot 107\n" +
                "bot 188 gives low to bot 92 and high to bot 75\n" +
                "bot 164 gives low to bot 115 and high to bot 28\n" +
                "bot 106 gives low to bot 48 and high to bot 155\n" +
                "bot 193 gives low to bot 101 and high to bot 110\n" +
                "bot 136 gives low to bot 166 and high to bot 152\n" +
                "bot 7 gives low to bot 156 and high to bot 24\n" +
                "bot 103 gives low to bot 182 and high to bot 0\n" +
                "bot 101 gives low to bot 16 and high to bot 72\n" +
                "bot 86 gives low to bot 102 and high to bot 48\n" +
                "bot 78 gives low to bot 177 and high to bot 113\n" +
                "value 17 goes to bot 198\n" +
                "bot 54 gives low to bot 161 and high to bot 111\n" +
                "bot 46 gives low to bot 74 and high to bot 39\n" +
                "bot 22 gives low to bot 56 and high to bot 161\n" +
                "bot 5 gives low to bot 186 and high to bot 123\n" +
                "bot 137 gives low to bot 202 and high to bot 85\n" +
                "bot 202 gives low to bot 108 and high to bot 118\n" +
                "bot 174 gives low to bot 0 and high to bot 21\n" +
                "bot 119 gives low to bot 68 and high to bot 53\n" +
                "bot 151 gives low to bot 83 and high to bot 164\n" +
                "bot 160 gives low to bot 33 and high to bot 97\n" +
                "bot 76 gives low to bot 40 and high to bot 120\n" +
                "bot 60 gives low to bot 103 and high to bot 174\n" +
                "bot 203 gives low to bot 120 and high to bot 132\n" +
                "bot 157 gives low to bot 116 and high to bot 11\n" +
                "bot 98 gives low to bot 208 and high to bot 16\n" +
                "bot 142 gives low to bot 114 and high to bot 71\n" +
                "bot 143 gives low to bot 198 and high to bot 146\n" +
                "bot 30 gives low to bot 59 and high to bot 135\n" +
                "bot 87 gives low to bot 39 and high to bot 104\n" +
                "bot 161 gives low to bot 173 and high to bot 125\n" +
                "bot 104 gives low to bot 34 and high to bot 68\n" +
                "bot 70 gives low to bot 112 and high to bot 176\n" +
                "bot 92 gives low to bot 122 and high to bot 46\n" +
                "bot 148 gives low to bot 28 and high to bot 58\n" +
                "bot 49 gives low to output 0 and high to bot 33\n" +
                "bot 140 gives low to bot 136 and high to bot 134\n" +
                "bot 16 gives low to bot 170 and high to bot 79\n" +
                "bot 13 gives low to bot 204 and high to bot 22\n" +
                "bot 189 gives low to bot 148 and high to bot 45\n" +
                "bot 89 gives low to bot 73 and high to bot 86\n" +
                "value 31 goes to bot 50\n" +
                "bot 166 gives low to bot 199 and high to bot 76\n" +
                "bot 178 gives low to output 5 and high to bot 159\n" +
                "bot 58 gives low to bot 167 and high to bot 126\n" +
                "bot 149 gives low to bot 180 and high to bot 153\n" +
                "bot 131 gives low to bot 97 and high to bot 66\n" +
                "bot 64 gives low to bot 192 and high to bot 44\n" +
                "bot 117 gives low to bot 140 and high to bot 134\n" +
                "bot 156 gives low to bot 174 and high to bot 154\n" +
                "value 11 goes to bot 19\n" +
                "bot 1 gives low to bot 26 and high to bot 144\n" +
                "bot 171 gives low to output 7 and high to bot 150\n" +
                "bot 31 gives low to bot 110 and high to bot 127\n" +
                "value 5 goes to bot 162\n" +
                "bot 9 gives low to bot 8 and high to bot 128\n" +
                "bot 93 gives low to bot 109 and high to bot 188\n" +
                "value 47 goes to bot 184\n" +
                "bot 80 gives low to output 19 and high to bot 42\n" +
                "bot 155 gives low to bot 149 and high to bot 52\n" +
                "bot 108 gives low to output 14 and high to bot 47\n" +
                "bot 165 gives low to bot 200 and high to bot 141\n" +
                "bot 184 gives low to bot 162 and high to bot 20\n" +
                "bot 50 gives low to bot 143 and high to bot 4\n" +
                "bot 28 gives low to bot 80 and high to bot 167\n" +
                "bot 66 gives low to bot 151 and high to bot 55\n" +
                "bot 201 gives low to bot 124 and high to bot 41\n" +
                "bot 204 gives low to bot 94 and high to bot 56\n" +
                "bot 134 gives low to bot 152 and high to bot 203\n" +
                "bot 51 gives low to bot 36 and high to bot 142\n" +
                "bot 2 gives low to bot 52 and high to bot 201\n" +
                "bot 183 gives low to bot 38 and high to bot 78\n" +
                "bot 26 gives low to bot 142 and high to bot 69\n" +
                "bot 182 gives low to bot 3 and high to bot 105\n" +
                "bot 72 gives low to bot 79 and high to bot 209\n" +
                "bot 8 gives low to bot 185 and high to bot 65\n" +
                "bot 75 gives low to bot 46 and high to bot 87\n" +
                "bot 38 gives low to bot 82 and high to bot 177\n" +
                "bot 147 gives low to bot 159 and high to bot 207\n" +
                "bot 195 gives low to bot 104 and high to bot 119\n" +
                "bot 63 gives low to bot 126 and high to bot 172\n" +
                "bot 144 gives low to bot 69 and high to bot 82\n" +
                "bot 83 gives low to output 3 and high to bot 115\n" +
                "bot 43 gives low to bot 194 and high to bot 91\n" +
                "value 37 goes to bot 8\n" +
                "bot 82 gives low to bot 193 and high to bot 31\n" +
                "bot 150 gives low to output 18 and high to bot 49\n" +
                "value 23 goes to bot 182\n" +
                "bot 67 gives low to bot 61 and high to bot 165\n" +
                "bot 77 gives low to bot 107 and high to bot 122\n" +
                "bot 130 gives low to bot 141 and high to bot 30\n" +
                "value 73 goes to bot 12\n" +
                "bot 41 gives low to bot 99 and high to bot 208\n" +
                "bot 170 gives low to bot 131 and high to bot 6\n" +
                "bot 120 gives low to bot 195 and high to bot 132\n" +
                "bot 118 gives low to bot 47 and high to bot 129\n" +
                "bot 100 gives low to bot 150 and high to bot 163\n" +
                "value 67 goes to bot 185\n" +
                "bot 152 gives low to bot 76 and high to bot 203\n" +
                "bot 162 gives low to bot 67 and high to bot 205\n" +
                "value 7 goes to bot 32\n" +
                "bot 121 gives low to bot 172 and high to bot 158\n" +
                "bot 65 gives low to bot 57 and high to bot 5\n" +
                "bot 122 gives low to bot 81 and high to bot 74\n" +
                "bot 21 gives low to bot 13 and high to bot 17\n" +
                "bot 23 gives low to bot 133 and high to bot 1\n" +
                "bot 36 gives low to bot 201 and high to bot 114\n" +
                "bot 138 gives low to bot 160 and high to bot 131\n" +
                "bot 55 gives low to bot 164 and high to bot 148\n" +
                "bot 123 gives low to bot 70 and high to bot 176\n" +
                "value 61 goes to bot 61\n" +
                "bot 107 gives low to bot 17 and high to bot 81\n" +
                "bot 19 gives low to bot 60 and high to bot 156\n" +
                "value 41 goes to bot 12\n" +
                "value 29 goes to bot 18\n" +
                "value 13 goes to bot 60\n" +
                "bot 62 gives low to bot 20 and high to bot 64\n" +
                "bot 40 gives low to bot 87 and high to bot 195\n" +
                "bot 90 gives low to bot 64 and high to bot 112\n" +
                "bot 69 gives low to bot 71 and high to bot 193\n" +
                "bot 35 gives low to output 4 and high to bot 108\n" +
                "bot 177 gives low to bot 31 and high to bot 113\n" +
                "bot 59 gives low to bot 93 and high to bot 27\n" +
                "bot 187 gives low to bot 89 and high to bot 94\n" +
                "bot 73 gives low to output 9 and high to bot 102\n" +
                "bot 45 gives low to bot 58 and high to bot 63\n" +
                "bot 39 gives low to bot 23 and high to bot 34\n" +
                "bot 110 gives low to bot 72 and high to bot 190\n" +
                "bot 181 gives low to bot 15 and high to bot 93\n" +
                "bot 95 gives low to bot 7 and high to bot 15\n" +
                "bot 33 gives low to output 13 and high to bot 169\n" +
                "bot 20 gives low to bot 205 and high to bot 192\n" +
                "bot 158 gives low to bot 85 and high to bot 29\n" +
                "bot 61 gives low to bot 14 and high to bot 200\n" +
                "value 71 goes to bot 103\n" +
                "bot 192 gives low to bot 130 and high to bot 175\n" +
                "bot 112 gives low to bot 44 and high to bot 139\n" +
                "bot 96 gives low to bot 144 and high to bot 38\n" +
                "bot 32 gives low to output 11 and high to bot 73\n" +
                "bot 180 gives low to output 10 and high to bot 171\n" +
                "value 59 goes to bot 3\n" +
                "bot 208 gives low to bot 138 and high to bot 170\n" +
                "bot 198 gives low to bot 184 and high to bot 62\n" +
                "bot 207 gives low to output 16 and high to output 8\n" +
                "bot 196 gives low to bot 43 and high to bot 91\n" +
                "bot 10 gives low to bot 111 and high to bot 133\n" +
                "bot 168 gives low to bot 35 and high to bot 202\n" +
                "bot 113 gives low to bot 127 and high to bot 196\n" +
                "bot 169 gives low to output 20 and high to bot 83\n" +
                "bot 3 gives low to bot 18 and high to bot 187\n" +
                "bot 52 gives low to bot 153 and high to bot 124\n" +
                "bot 190 gives low to bot 209 and high to bot 43\n" +
                "bot 125 gives low to bot 2 and high to bot 36\n" +
                "bot 173 gives low to bot 155 and high to bot 2\n" +
                "bot 153 gives low to bot 171 and high to bot 100\n" +
                "bot 34 gives low to bot 1 and high to bot 96\n" +
                "bot 84 gives low to bot 90 and high to bot 70\n" +
                "bot 12 gives low to bot 9 and high to bot 128\n" +
                "bot 24 gives low to bot 154 and high to bot 77\n" +
                "bot 179 gives low to bot 63 and high to bot 121\n" +
                "bot 85 gives low to bot 118 and high to bot 29\n" +
                "bot 11 gives low to bot 189 and high to bot 145\n" +
                "bot 116 gives low to bot 55 and high to bot 189\n" +
                "bot 132 gives low to bot 119 and high to bot 53\n" +
                "bot 15 gives low to bot 24 and high to bot 109\n" +
                "bot 102 gives low to output 15 and high to bot 197\n" +
                "value 43 goes to bot 206\n" +
                "bot 37 gives low to bot 145 and high to bot 25\n" +
                "bot 53 gives low to bot 183 and high to bot 78\n" +
                "bot 197 gives low to output 12 and high to bot 180\n" +
                "bot 47 gives low to output 17 and high to bot 178\n" +
                "bot 17 gives low to bot 22 and high to bot 54\n" +
                "bot 56 gives low to bot 106 and high to bot 173\n" +
                "bot 191 gives low to bot 135 and high to bot 136\n" +
                "bot 127 gives low to bot 190 and high to bot 196\n" +
                "bot 172 gives low to bot 137 and high to bot 158\n" +
                "bot 4 gives low to bot 146 and high to bot 84\n" +
                "bot 42 gives low to output 6 and high to bot 35\n" +
                "bot 145 gives low to bot 45 and high to bot 179\n" +
                "bot 133 gives low to bot 51 and high to bot 26\n" +
                "bot 139 gives low to bot 88 and high to bot 117\n" +
                "bot 105 gives low to bot 187 and high to bot 204\n" +
                "bot 126 gives low to bot 168 and high to bot 137\n" +
                "bot 128 gives low to bot 65 and high to bot 5\n" +
                "bot 114 gives low to bot 41 and high to bot 98\n" +
                "bot 14 gives low to bot 206 and high to bot 95\n" +
                "bot 91 gives low to bot 37 and high to bot 25\n" +
                "bot 206 gives low to bot 19 and high to bot 7\n" +
                "value 19 goes to bot 14\n" +
                "bot 185 gives low to bot 50 and high to bot 57\n" +
                "bot 205 gives low to bot 165 and high to bot 130\n" +
                "bot 109 gives low to bot 77 and high to bot 92\n" +
                "bot 175 gives low to bot 30 and high to bot 191\n" +
                "bot 29 gives low to bot 129 and high to bot 147\n" +
                "bot 74 gives low to bot 10 and high to bot 23\n" +
                "bot 94 gives low to bot 86 and high to bot 106\n" +
                "bot 25 gives low to bot 179 and high to bot 121\n" +
                "bot 71 gives low to bot 98 and high to bot 101\n" +
                "bot 209 gives low to bot 157 and high to bot 194\n" +
                "bot 88 gives low to bot 191 and high to bot 140\n" +
                "bot 124 gives low to bot 100 and high to bot 99\n" +
                "bot 97 gives low to bot 169 and high to bot 151\n" +
                "bot 141 gives low to bot 181 and high to bot 59\n" +
                "bot 146 gives low to bot 62 and high to bot 90\n" +
                "bot 200 gives low to bot 95 and high to bot 181\n" +
                "bot 79 gives low to bot 6 and high to bot 157\n" +
                "bot 48 gives low to bot 197 and high to bot 149\n" +
                "value 3 goes to bot 67\n" +
                "bot 68 gives low to bot 96 and high to bot 183\n" +
                "bot 111 gives low to bot 125 and high to bot 51";

        Assert.assertEquals(47101, Day10Puzzle2.solve(input));
    }

}