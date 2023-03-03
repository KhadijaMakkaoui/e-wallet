import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:front_end/models/Transaction.dart';
import 'package:http/http.dart' as http;
import '../services/transaction_service.dart';
class Welcome extends StatefulWidget {
  const Welcome({Key? key}) : super(key: key);

  @override
  State<Welcome> createState() => _WelcomeState();
}

class _WelcomeState extends State<Welcome> {
/*
  List<dynamic> transactions = [];
*/

 /* @override
  void initState() {
    super.initState();
    fetchData();
  }

  Future<void> fetchData() async {
    final response = await http.get('http://165.232.123.254:8080/api/v1/transactions' as Uri);
    if (response.statusCode == 200) {
      setState(() {
        transactions = json.decode(response.body);
      });
    } else {
      throw Exception('Failed to load data');
    }
  }*/
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child:
          Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
                onPressed:
                    ()async{
                      var response=await TransactionService().get('/transactions');
                      if(response==null) return;
                      debugPrint('success');

/*
                      var transactions=transactionFromJson(response);
*/
                      print(response);
                      /*Navigator.pushNamed(context, '/home');*/

                    },
                child: const Text('Welcome')
            ),
          ],
        ),
      ),

    );
  }
}
