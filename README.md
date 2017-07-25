# MindValleyChallenge

ANDROID DEVELOPER CHALLENGE

Evaluation Criteria for this Assignment:

1. Readability:
Class and method names should clearly show their intent and responsibility.

2. Maintainability:
“SOLID” Principles and design pattern;
MVC model.

3. Scalability:
Your software should easily accommodate possible future requirement changes.

4. Testability: 
Please accompany your code with test classes.
Please use Android Studio for this project.

Requirements:

1. Use the following url for loading data: http://pastebin.com/raw/wgkJgazE
2. Images and JSON should be cached efficiently (in-memory only, no need for caching to disk);
3. The cache should have a configurable max capacity and should evict images not recently used;
4. An image load may be cancelled;
5. The same image may be requested by multiple sources simultaneously (even before it has loaded), and if one of the sources cancels the load, it should not affect the remaining requests;
6. Multiple distinct resources may be requested in parallel;
7. You can work under the assumption that the same URL will always return the same resource;
8. The library should be easy to integrate into new Android project / apps;
9. You are supposed to build a solid structure and use the needed programming design patterns;
10. Think that the list of item returned by the API can reach 100 items or even more. At a time, you should only load 10 items, and load more from the API when the user reach the end of the list;
11. Usage of Material Design UI elements (Ripple, Fab button, Animations) is an advantage;
12. Adding "pull to refresh" is an advantage.

----------------------------------------------------------------------------------------------------------------------------------------

Screenshot of the Application:

 ![menu](https://user-images.githubusercontent.com/27500484/28566331-673307fc-7161-11e7-908d-9e6a768e4fad.png) ![cache-cleared](https://user-images.githubusercontent.com/27500484/28566393-9b968816-7161-11e7-969d-d2ede8690d27.png) ![galery](https://user-images.githubusercontent.com/27500484/28566406-a00865e0-7161-11e7-898a-dd9172c725d9.png)
![refresh - gallery](https://user-images.githubusercontent.com/27500484/28566409-a1645408-7161-11e7-882d-edf34fb08e88.png)
