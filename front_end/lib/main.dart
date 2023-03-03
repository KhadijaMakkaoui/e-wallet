import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:front_end/screens/home.dart';
import 'package:front_end/screens/transaction_deposit.dart';
import 'package:front_end/screens/welcome.dart';
void main() {
  runApp(const MyApp());
}
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    SystemChrome.setSystemUIOverlayStyle(
      const SystemUiOverlayStyle(
        statusBarColor: Colors.transparent,
        statusBarIconBrightness: Brightness.dark,
      ),
    );
    return MaterialApp(
      initialRoute: '/home',
      routes: {
        '/': (context) => const Welcome(),
        '/home': (context) => const HomePage(),
        '/deposit': (context) => const Deposit(),
      },
      debugShowCheckedModeBanner: false,
      title: 'Bankly',
    );
  }
}