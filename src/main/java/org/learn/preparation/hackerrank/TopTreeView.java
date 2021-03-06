package org.learn.preparation.hackerrank;

import java.util.Map;
import java.util.Set;

public class TopTreeView {

    Node root;

    public void add(int newValue) {
        Node current = root;
        if (current == null) {
            root = new Node(newValue);
        } else {
            do {
                if (current.data > newValue) {
                    if (current.left == null) {
                        Node leftNode = new Node(newValue);
                        current.left = leftNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        Node rightNode = new Node(newValue);
                        current.right = rightNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            } while (true);
        }
    }

    private static void leftTopView(Node root) {
        if (root != null) {
            if (root.left != null)
                leftTopView(root.left);
            System.out.print(root.data + " ");
        }
    }

    private static void rightTopView(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            if (root.right != null)
                rightTopView(root.right);
        }
    }

    public static void topView(Node root) {
        if (root.left != null)
            leftTopView(root.left);

        System.out.print(root.data + " ");

        if (root.right != null)
            rightTopView(root.right);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        String str = "13 105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198 122 130 183 361 274 291 25 146 121 321 268 273 36 316 216 70 171 75 380 296 66 264 398 359 87 338 355 220 288 225 21 94 157 207 86 97 235 83 381 221 61 42 111 150 320 188 123 300 215 329 267 170 18 167 224 265 293 23 124 212 39 376 326 378 169 415 65 365 394 245 182 211 242 350 336 385 342 233 84 283 228 154 166 418 206 389 214 133 347 232 275 52 402 287 2 318 93 280 248 313 1 131 209 412 406 249 325 276 6 286 9 333 403 314 262 387 30 56 362 141 11 109 417 136 139 322 223 246 101 80 294 404 319 32 69 20 115 174 366 252 90 384 159 411 203";


        TopTreeView b = new TopTreeView();
        //3 5 2 1 4 6 7
        String[] nums = str.split(" ");
        Node root = null;
        for (String s : nums) {
            root = insert(root, Integer.valueOf(s));
        }
        //17 1 2 3 4 13 105 278 372 377 393 409 416 418

        TopTreeView.topView(root);

        /*
        * 418
        * 13 105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198 122 130 183 361 274 291 25 146 121 321 268 273 36 316 216 70 171 75 380 296 66 264 398 359 87 338 355 220 288 225 21 94 157 207 86 97 235 83 381 221 61 42 111 150 320 188 123 300 215 329 267 170 18 167 224 265 293 23 124 212 39 376 326 378 169 415 65 365 394 245 182 211 242 350 336 385 342 233 84 283 228 154 166 418 206 389 214 133 347 232 275 52 402 287 2 318 93 280 248 313 1 131 209 412 406 249 325 276 6 286 9 333 403 314 262 387 30 56 362 141 11 109 417 136 139 322 223 246 101 80 294 404 319 32 69 20 115 174 366 252 90 384 159 411 203
        * output: 17 1 2 3 4 13 105 278 372 377 393 409 416 418
         * */

        System.out.println(" geeks");

        Node root1 = null;
        root1= insert(root1,10);
        root1= insert(root1,5);
        root1= insert(root1,15);
        root1= insert(root1,1);
        root1= insert(root1,6);
        root1= insert(root1,14);
        root1= insert(root1,17);

        //            10
        //       5         15
        //   1     6    14     17
        //
        //
        //
        topView(root1);

        Map<Integer, Integer> abc;

        Set<Integer> set;


    }


}
