<?php

namespace App\Http\Controllers;

use App\Http\Requests;
use Illuminate\Http\Request;
use JWTAuth;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return view('home');
    }

    public function returnToken()
    {
        $credential = ['email'=> '123456@qq.com', 'password'=> '12356'];
        echo $jwt =  JWTAuth::attempt($credential);
        
//        var_dump($a);
    }
    
    public function getUser()
    {
        $user = JWTAuth::parseToken()->toUser();
        return response()->json(['Status' => 200, 'data' => $user]);
    }
}
