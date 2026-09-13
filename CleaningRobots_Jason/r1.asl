
at(P) :- pos(P,X,Y) & pos(r1,X,Y).

/* Initial goal */

!check(slots).

/* Plans */

+!check(slots) : scan_done
   <- .print("r1: scan of rows 0-3 complete.").

+!check(slots) : not garbage(r1)
   <- next(slot);
      !check(slots).


+garbage(r1) : not .desire(carry_to(r2))
   <- !carry_to(r2).

+!carry_to(R)
   <- .drop_desire(check(slots));

      ?pos(r1,X,Y);
      -+pos(last,X,Y);

      !take(garb,R);

      !at(last);
      !!check(slots).


+!take(S,L)
   <- !ensure_pick(S);
      !at(L);
      drop(S).

+!ensure_pick(S) : garbage(r1)
   <- pick(garb);
      !ensure_pick(S).
+!ensure_pick(_).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move_towards(X,Y);
           !at(L).
