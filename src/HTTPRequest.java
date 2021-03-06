/**
 * Process HTTPRequest
 * @author Thomas Kelly
 * the HTTPRequest class accepts an HTTP request from a web browser and extracts the relevant path of the file to be returned to the web browser
 * Uses the error handling found in the tinyWS Class
 */

public class HTTPRequest {
    private String request;         // request string
    private String path;            // path to file
    private boolean validRequest;   // is request valid?

    public HTTPRequest(String r) {
        // TODO Constructor
        this.request = r;
        this.validRequest = parse(r);
    }

    /**
     * @return returns true if the request is valid. Validity determined in the parse function during construction
     */
    public boolean isValidRequest() {
        return (validRequest);
    }

    /**
     * @return returns the path in a syntactically correct HTTP request
     */
    public String getPath() {
        return (path);
    }

    /**
     *
     * @param r
     * @return returns true if the passed in string r was successfully parsed/syntactically valid
     * uses the error handling in the TinyWS class
     */
    // TODO uncomment
     private boolean parse(String r) {
          //TODO code here

         String[] split = r.split("[\t\n?]");

         if(split.length < 2){
             TinyWS tiny = new TinyWS();
             tiny.fatalError("Incorrect number of HTTP Request Tokens: " + r);
//             return false;
         }

         if(!"GET".equals(split[0].toUpperCase())){
             TinyWS tiny = new TinyWS();
             tiny.fatalError("HTTP Request does not begin with GET: " + r);
//             return false;
         }

         if("".equals(split[1]) || split[1] == null){
             TinyWS tiny = new TinyWS();
             tiny.fatalError("Second HTTP Request Token missing or NULL: " + r);
//             return false;
         }else{
             this.path = split[1];
         }
         return true;
     }
}
