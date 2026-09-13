// mars robot 3

/* Initial beliefs */

at(P) :- pos(P,X,Y) & pos(r3,X,Y).

/* Initial goal */

!check(slots).

/* Plans */

+!check(slots) : scan_done
   <- .print("r3: scan of rows 4-6 complete.").

+!check(slots) : not garbage(r3)
   <- next(slot);
      !check(slots).


+garbage(r3) : not .desire(carry_to(r2))
   <- !carry_to(r2).

+!carry_to(R)
   <- .drop_desire(check(slots));

      ?pos(r3,X,Y);
      -+pos(last,X,Y);

      !take(garb,R);

      !at(last);
      !!check(slots).


+!take(S,L)
   <- !ensure_pick(S);
      !at(L);
      drop(S).

+!ensure_pick(S) : garbage(r3)
   <- pick(garb); 
      !ensure_pick(S).
+!ensure_pick(_).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move_towards(X,Y);
           !at(L).
