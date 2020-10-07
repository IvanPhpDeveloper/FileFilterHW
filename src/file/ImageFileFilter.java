package file;



    public class ImageFileFilter extends ExtentionFileFilter {
        public ImageFileFilter(String contains) {
            super(contains,
                    "gif",
                    "tiff",
                    "psd",
                    "pdf",
                    "jpeg",
                    "jpg",
                    "bmp",
                    "png"
            );
        }


    }




