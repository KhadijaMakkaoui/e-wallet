import 'package:flutter/material.dart';
import 'package:front_end/widgets/transactions_list_view.dart';

import '../models/Transaction.dart';
import '../services/transaction_service.dart';
class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Transaction> transactionsList = [];
  @override
  void initState() {
    super.initState();
    _getTransactions();

  }
  void _getTransactions() async {
    var response=await TransactionService().get('/transactions');
    if(response==null) return;
    debugPrint('success');

    // parse the response into a list of Transaction objects
    List<Transaction> transactions = (response as List).map((transaction) => Transaction.fromJson(transaction)).toList();

    // set the transactionsList to the parsed list
    setState(() {
      transactionsList = transactions;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: [
            const CircleAvatar(
              backgroundImage: AssetImage('assets/person.jpg'),
              radius: 20,
            ),
            const SizedBox(width: 10),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: const [
                Text(
                  'Bonjour,',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize:18,
                    fontWeight: FontWeight.w200,
                  ),
                ),
                Text(
                  'Khadija Makkaoui',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                    fontWeight: FontWeight.w400,
                  ),
                ),
              ],
            ),
          ],
        ),
        centerTitle: true,
        backgroundColor: Colors.lightBlue[600],
        elevation: 0,
      ),
      body: Container(
        padding: const EdgeInsets.only(top: 20),
        color: Colors.lightBlue[600],
        child:Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Column(
              children: const [
                Text(
                  'Balance',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 25,
                    fontWeight: FontWeight.w300,
                  ),
                ),
                SizedBox(height: 10),
                Text(
                  '1000 MAD',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 40,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],

            ),
            const SizedBox(height: 50),
            Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children:[
                  GestureDetector(
                    onTap: () {
                      // do something when the text is clicked
                    },
                    child: const Text(
                      'CREDITER',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                  ),

                  const SizedBox(width: 10),
                  GestureDetector(
                    onTap: () {
                      // do something when the text is clicked
                    },
                    child: const Text(
                      'DEBITER',
                      style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                      ),
                    ),
                  ),
                ]
            ),
            Expanded(
                child: Container(
                  padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
                  margin: const EdgeInsets.only(top: 50),
                  decoration: const BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.only(
                      topLeft: Radius.circular(30),
                      topRight: Radius.circular(30),

                    ),
                  ) ,
                  child: Column(
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          const Text('Transactions Récentes',
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                              )),
                          GestureDetector(
                            onTap: () {
                              // do something when the text is clicked
                            },
                            child: const Text(
                              'Voir Plus',
                              style: TextStyle(
                                color: Colors.blue,
                                fontWeight: FontWeight.bold,
                                fontSize: 15,
                              ),
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 20),
                      Container(
                        height: 400,
                        child:
                        TransactionListView(transactions:transactionsList),
                      )

                    ],
                  ),

                ))
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: 0,
        selectedItemColor: Colors.blue,
        unselectedItemColor: Colors.grey,
        onTap: (index) {
          setState(() {
            // _selectedIndex = index;
          });
        },
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.account_balance_wallet),
            label: 'Wallet',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.history),
            label: 'Bank',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: 'Profile',
          ),
        ],

      ),


    );
  }


}