
import 'dart:convert';
import 'package:http/http.dart' as http;
const String baseUrl = 'http://165.232.123.254:8080/api/v1';
/*https://6400b93329deaba5cb3e4170.mockapi.io/api/v1*/
class TransactionService{
  var client=http.Client();

  //GET
   Future<dynamic> get(String api) async{
    var url=Uri.parse(baseUrl + api);
    var response=await http.get(url);
    if(response.statusCode==200){
      return json.decode(response.body);
    }else{
      throw Exception('Failed to fetch data from the API');
    }
  }
  Future<dynamic> post(String api, Map<String, dynamic> body) async{}
  Future<dynamic> put(String api, Map<String, dynamic> body) async{}
  Future<dynamic> delete(String api) async{}
}
