package io.grpc.internal;

class RetriableStream$1AuthorityEntry implements RetriableStream$BufferEntry {
    final /* synthetic */ RetriableStream this$0;
    final /* synthetic */ String val$authority;

    RetriableStream$1AuthorityEntry(RetriableStream retriableStream, String str) {
        this.this$0 = retriableStream;
        this.val$authority = str;
    }

    public void runWith(RetriableStream$Substream retriableStream$Substream) {
        retriableStream$Substream.stream.setAuthority(this.val$authority);
    }
}
