/*******************************************************************************
 * Copyright 2014, barter.li
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package li.barter.http;

/**
 * @author Vinay S Shenoy Interface that holds all constants related to Http
 *         Requests
 */
public class HttpConstants {

	/**
	 * Enum to switch between servers
	 */
	private enum Server {

		LOCAL("http://162.243.198.171/api/v", API_VERSION, "http://162.243.198.171/api/v1/chat"), DEV(
				"http://162.243.198.171/api/v", API_VERSION, ""), PRODUCTION(
				"http://162.243.198.171/api/v", API_VERSION, "");

		public final String mApiUrl;
		public final String mSocketUri;

		Server(String url, int version, String socketUri) {
			mApiUrl = url + version;
			mSocketUri = socketUri;
		}
	}

	private static final int API_VERSION = 1;

	private static Server SERVER = Server.LOCAL;

	public static String getApiBaseUrl() {
		return SERVER.mApiUrl;
	}

	public static String getSocketUri() {
		return SERVER.mSocketUri;
	}

	/**
	 * Empty interface to remember all API endpoints
	 */
	public static interface ApiEndpoints {
		public static final String BOOK_SUGGESTIONS = "/book_suggestions.json";
		public static final String BOOK_INFO = "/book_info.json";
		public static final String BOOKS = "/books.json";
		public static final String CREATE_USER = "/create_user.json";
		public static final String HANGOUTS = "/hangouts.json";
		public static final String USER_PREFERRED_LOCATION = "/user_preferred_location.json";
	}

	public static final String CHAT_SOCKET_ENDPOINT = "";

	/* Keys used in Http requests and responses */
	public static final String Q = "q";
	public static final String T = "t";
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String AUTHORS = "authors";
	public static final String AUTHOR = "author";
	public static final String NAME = "name";
	public static final String PUBLICATION_YEAR = "publication_year";

}
