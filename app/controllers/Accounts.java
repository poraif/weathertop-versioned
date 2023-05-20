package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller
{
    public static void signup()
    {
        render("signup.html");
    }

    public static void login()
    {
        render("login.html");
    }


        public static void update() {
            Member member = Accounts.getLoggedInMember();
            render("update.html", member);
        }



    public static void register(String firstname, String lastname, String email, String password)
    {
        Logger.info("Registering new user " + email);
        Member member = new Member(firstname, lastname, email, password);
        member.save();
        redirect("/");
    }

    public static void updateDetails(String firstname, String lastname, String password)
    {
        Member member = Accounts.getLoggedInMember();
            member.firstname = firstname;
            member.lastname = lastname;
            member.password = password;
            member.save();
        Logger.info("Updating user " + getLoggedInMember().email);
        render ("updatedetails.html", member);
        redirect("/dashboard.html");
    }


    public static void authenticate(String email, String password)
    {
        Logger.info("Attempting authentication: " + email + ":" + password);

        Member member = Member.findByEmail(email);
        if ((member != null) && (member.checkPassword(password) == true)) {
            Logger.info("Authentication successful");
            session.put("logged_in_Memberid", member.id);
            redirect ("/dashboard");
        } else {
            Logger.info("Authentication failed");
            redirect("/login");
        }
    }

    public static void logout()
    {
        session.clear();
        redirect ("/");
    }

    public static Member getLoggedInMember()
    {
        Member member = null;
        if (session.contains("logged_in_Memberid")) {
            String memberId = session.get("logged_in_Memberid");
            member = Member.findById(Long.parseLong(memberId));
        } else {
            login();
        }
        return member;
    }







}
